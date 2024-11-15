const mysql = require('mysql2');
const readline = require('readline');
const fs = require('fs');

// Configuración de conexión a la base de datos
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',         // Cambia 'your_user' por tu usuario de MySQL
  password: 'root', // Cambia 'your_password' por tu contraseña de MySQL
  database: 'dbunificada', // Cambia 'your_database' por el nombre de tu base de datos
});

// Función para leer e insertar datos desde un archivo
async function readAndInsertData(filePath, tableName, columns) {
    const fileStream = fs.createReadStream(filePath);
    const rl = readline.createInterface({
        input: fileStream,
        crlfDelay: Infinity
    });

    const insertQuery = `INSERT INTO ${tableName} (${columns.join(', ')}) VALUES ?`;
    const values = [];

    for await (const line of rl) {
        // Divide la línea en campos
        const fields = line.split('|');  // Ajusta el separador si es diferente
        values.push(fields);
    }

    connection.query(insertQuery, [values], (error) => {
        if (error) throw error;
        console.log(`Datos insertados en ${tableName}`);
    });
}

// Insertar datos en cada tabla usando los archivos correspondientes
async function insertAllData() {
    await readAndInsertData('programa1.txt', 'programa_1', [
        'regimen_de_afiliacion', 'localidad_calculada', 'asegurador',
        'fecha_de_nacimiento_usuario', 'sexo', 'fecha_de_la_consulta', 'nacionalidad'
    ]);

    await readAndInsertData('programa2.txt', 'programa_2', [
        'sexo_biologico', 'localidad', 'eapb', 'fecha_de_nacimiento',
        'pertenencia_etnica', 'sexo_biologico_1', 'riesgo_psicosocial',
        'fecha_de_la_consulta', 'talla'
    ]);

    await readAndInsertData('programa3.txt', 'programa_3', [
        'localidadfic_3', 'nacionalidad_10', 'nombreeapb_27', 'fechadenacimiento_14',
        'etnia_18', 'sexo_11', 'genero_12', 'fechaintervencion_2'
    ]);

    await readAndInsertData('programa4.txt', 'programa_4', [
        'localidad_fic', 'estado_civil', 'nombre_eapb', 'fecha_de_nacimiento',
        'etnia', 'sexo', 'fecha_intervencion'
    ]);
}

// Ejecuta el script de inserción
insertAllData().then(() => {
    console.log("Todos los datos han sido insertados.");
    connection.end();  // Cierra la conexión después de la inserción
}).catch(err => {
    console.error("Error al insertar datos:", err);
});



// Leer el archivo SQL para crear la vista
/*const createView = fs.readFileSync('create_view.sql', 'utf-8');

// Ejecutar el script SQL para crear la vista consolidada
connection.query(createView, (err) => {
  if (err) throw err;
  console.log('VISTA_CONSOLIDADO creada exitosamente.');

  // Consultar la vista y exportar resultados a un archivo .txt
  connection.query('SELECT * FROM VISTA_CONSOLIDADO', (err, results) => {
    if (err) throw err;

    // Convertir resultados a formato de texto
    const data = results.map(row => JSON.stringify(row)).join('\n');
    
    // Guardar en un archivo .txt
    fs.writeFileSync('consolidated_output.txt', data, 'utf-8');
    console.log('Datos exportados a consolidated_output.txt');

    connection.end();
  });
});*/
