-- Tabla para PROGRAMA 1
CREATE TABLE programa_1 (
    regimen_de_afiliacion VARCHAR(50),
    localidad_calculada VARCHAR(50),
    asegurador VARCHAR(50),
    fecha_de_nacimiento_usuario DATE,
    sexo VARCHAR(10),
    fecha_de_la_consulta DATE,
    nacionalidad VARCHAR(50)
);

-- Tabla para PROGRAMA 2
CREATE TABLE programa_2 (
    sexo_biologico VARCHAR(10),
    localidad VARCHAR(50),
    eapb VARCHAR(50),
    fecha_de_nacimiento DATE,
    pertenencia_etnica VARCHAR(50),
    sexo_biologico_1 VARCHAR(10),
    riesgo_psicosocial VARCHAR(50),
    fecha_de_la_consulta DATE,
    talla DECIMAL(5,2)
);

-- Tabla para PROGRAMA 3
CREATE TABLE programa_3 (
    localidadfic_3 VARCHAR(50),
    nacionalidad_10 VARCHAR(50),
    nombreeapb_27 VARCHAR(50),
    fechadenacimiento_14 DATE,
    etnia_18 VARCHAR(50),
    sexo_11 VARCHAR(10),
    genero_12 VARCHAR(10),
    fechaintervencion_2 DATE
);

-- Tabla para PROGRAMA 4
CREATE TABLE programa_4 (
    localidad_fic VARCHAR(50),
    estado_civil VARCHAR(50),
    nombre_eapb VARCHAR(50),
    fecha_de_nacimiento DATE,
    etnia VARCHAR(50),
    sexo VARCHAR(10),
    fecha_intervencion DATE
);
