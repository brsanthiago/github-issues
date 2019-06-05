package br.com.brsantiago.extensions

import java.text.SimpleDateFormat
import java.util.*


inline fun Date.toView(): String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this)