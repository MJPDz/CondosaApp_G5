package com.example.mvvm_condosa.data.DAO

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvm_condosa.data.Entity.PredioEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime


@RequiresApi(Build.VERSION_CODES.O)
val mesActual = LocalDateTime.now().monthValue
class RegistroDAO {
    // suspend fun obtenerImporte(id:Int): List<String> = withContext(Dispatchers.IO) {
        ///transaction {
          //  val result = (Caja innerJoin OtraEntidad)
              //  .slice(CajaChicaEntity.periodo)
            //    .selectAll()
               // .mapNotNull { it[CajaChicaEntity.periodo] }

           // return@transaction result
        }
   // }

//}
