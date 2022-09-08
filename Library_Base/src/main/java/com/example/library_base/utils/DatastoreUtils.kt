package com.example.library_base.utils

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.io.IOException

object DatastoreUtils {
    private lateinit var dataStore: DataStore<Preferences>
    private const val preferenceName = "DS"

    /**
     * 初始化
     */
    fun init(context: Context) {
        dataStore = context.createDataStore(preferenceName)
    }

    /**
     * 在协程中获取数据
     */
    fun <T> getValue(key: String, defaultValue: T): Flow<T> {
        val value = when (defaultValue) {
            is Long -> readLongFlowValue(key, defaultValue)
            is String -> readStringFlowValue(key, defaultValue)
            is Int -> readIntFlowValue(key, defaultValue)
            is Boolean -> readBooleanFlowValue(key, defaultValue)
            is Float -> readFloatFlowValue(key, defaultValue)
            is Double -> readDoubleFlowValue(key, defaultValue)
            else -> Log.e("DataStoreUtil","的 getValue方法出错defaultValue的这种数据类型出错")
        }
        return value as Flow<T>
    }

    /**
     * 同步获取数据
     */
    fun <T> getSyncValue(key: String, defaultValue: T): T {
        val value = when (defaultValue) {
            is Long -> readLongData(key, defaultValue)
            is String -> readStringData(key, defaultValue)
            is Int -> readIntData(key, defaultValue)
            is Boolean -> readBooleanData(key, defaultValue)
            is Float -> readFloatData(key, defaultValue)
            is Double -> readDoubleData(key, defaultValue)
            else -> Log.e("DataStoreUtil","的 getSyncValue方法出错defaultValue的这种数据类型出错")
        }
        return value as T
    }

    /**
     * 异步存储数据
     */
    suspend fun <T> putValue(key: String, value: T) {
        when (value) {
            is Long -> saveLongValue(key, value)
            is Int -> saveIntValue(key, value)
            is Double -> saveDoubleValue(key, value)
            is Float -> saveFloatValue(key, value)
            is Boolean -> saveBooleanValue(key, value)
            is String -> saveStringValue(key, value)
            else -> Log.e("DataStoreUtil","的 putValue方法出错defaultValue的这种数据类型出错")
        }
    }

    /**
     * 同步存储数据
     */
    fun <T> putSyncValue(key: String, value: T) {
        when (value) {
            is Long -> saveLongSyncValue(key, value)
            is Int -> saveIntSyncValue(key, value)
            is Double -> saveDoubleSyncValue(key, value)
            is Float -> saveFloatSyncValue(key, value)
            is Boolean -> saveBooleanSyncValue(key, value)
            is String -> saveStringSyncValue(key, value)
            else -> Log.e("DataStoreUtil","的 putSyncValue方法出错defaultValue的这种数据类型出错")
        }
    }

    /**
     * 异步清除
     */
    suspend fun clear() {
        dataStore.edit {
            it.clear()
        }
    }

    /**
     * 同步清除
     */
    fun clearSync() {
        runBlocking {
            dataStore.edit {
                it.clear()
            }
        }
    }

    suspend fun removeString(key:String){
        dataStore.edit {
            it.remove(stringPreferencesKey(key))
        }
    }

//    suspend fun removeBoolean

    private fun saveStringSyncValue(key: String, value: String)=
        runBlocking {
            saveStringValue(key,value)
        }

    private fun saveBooleanSyncValue(key: String, value: Boolean) =
        runBlocking {
            saveBooleanValue(key,value)
        }

    private fun saveFloatSyncValue(key: String, value: Float) =
        runBlocking {
            saveFloatValue(key,value)
        }

    private fun saveDoubleSyncValue(key: String, value: Double) =
        runBlocking {
            saveDoubleValue(key,value)
        }

    private fun saveIntSyncValue(key: String, value: Int) =
        runBlocking {
            saveIntValue(key,value)
        }

    private fun saveLongSyncValue(key: String, value: Long) =
        runBlocking {
            saveLongValue(key, value)
        }


    private suspend fun saveStringValue(key: String, value: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[stringPreferencesKey(key)] = value
        }
    }

    private suspend fun saveBooleanValue(key: String, value: Boolean) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[booleanPreferencesKey(key)] = value
        }
    }

    private suspend fun saveFloatValue(key: String, value: Float) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[floatPreferencesKey(key)] = value
        }

    }

    private suspend fun saveDoubleValue(key: String, value: Double) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[doublePreferencesKey(key)] = value
        }
    }

    private suspend fun saveIntValue(key: String, value: Int) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[intPreferencesKey(key)] = value
        }
    }

    private suspend fun saveLongValue(key: String, value: Long) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[longPreferencesKey(key)] = value
        }
    }

    private fun readDoubleData(key: String, defaultValue: Double = 0.00): Double {
        var value = 0.00
        runBlocking {
            dataStore.data.first {
                value = it[doublePreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }


    private fun readDoubleFlowValue(key: String, defaultValue: Double): Flow<Double> =
        dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[doublePreferencesKey(key)] ?: defaultValue
        }

    private fun readFloatFlowValue(key: String, defaultValue: Float = 0f): Flow<Float> =
        dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[floatPreferencesKey(key)] ?: defaultValue
        }


    private fun readBooleanFlowValue(key: String, defaultValue: Boolean = false): Flow<Boolean> =
        dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[booleanPreferencesKey(key)] ?: defaultValue
        }

    private fun readIntFlowValue(key: String, defaultValue: Int = 0): Flow<Int> =
        dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[intPreferencesKey(key)] ?: defaultValue
        }


    private fun readStringFlowValue(key: String, defaultValue: String): Flow<String> =
        dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[stringPreferencesKey(key)] ?: defaultValue
        }

    private fun readLongFlowValue(key: String, defaultValue: Long = 0L): Long {
        var value = 0L
        runBlocking {
            dataStore.data.first {
                value = it[longPreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }

    private fun readFloatData(key: String, defaultValue: Float = 0f): Float {
        var value = 0f
        runBlocking {
            dataStore.data.first {
                value = it[floatPreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }

    private fun readBooleanData(key: String, defaultValue: Boolean = false): Boolean {
        var value = false
        runBlocking {
            dataStore.data.first {
                value = it[booleanPreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }

    private fun readIntData(key: String, defaultValue: Int = 0): Int {
        var value = 0
        runBlocking {
            dataStore.data.first {
                value = it[intPreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }

    private fun readStringData(key: String, defaultValue: String = ""): String {
        var value = ""
        runBlocking {
            dataStore.data.first {
                value = it[stringPreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }

    private fun readLongData(key: String, defaultValue: Long = 0L): Long {
        var value = 0L
        runBlocking {
            dataStore.data.first {
                value = it[longPreferencesKey(key)] ?: defaultValue
                true
            }
        }
        return value
    }
}