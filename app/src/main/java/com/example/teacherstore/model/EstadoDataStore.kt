package com.example.teacherstore.model

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore("preferencias_usuario")