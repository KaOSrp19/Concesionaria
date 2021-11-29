
CREATE TABLE Cliente (
                nif VARCHAR(25) NOT NULL,
                direccion VARCHAR(50) NOT NULL,
                telefono INT NOT NULL,
                nombre VARCHAR(50) NOT NULL,
                ciudad VARCHAR(50) NOT NULL,
                PRIMARY KEY (nif)
);


CREATE TABLE Coches (
                matricula VARCHAR(25) NOT NULL,
                marca VARCHAR(50) NOT NULL,
                precio DOUBLE PRECISION NOT NULL,
                modelo VARCHAR(50) NOT NULL,
                color VARCHAR(50) NOT NULL,
                nif VARCHAR(25) NOT NULL,
                PRIMARY KEY (matricula)
);


CREATE TABLE revisiones (
                codigo VARCHAR(25) NOT NULL,
                aceite VARCHAR(100) NOT NULL,
                frenos VARCHAR(100) NOT NULL,
                filtro VARCHAR(100) NOT NULL,
                matricula VARCHAR(25) NOT NULL,
                PRIMARY KEY (codigo)
);


ALTER TABLE Coches ADD CONSTRAINT cliente_coches_fk
FOREIGN KEY (nif)
REFERENCES Cliente (nif)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE revisiones ADD CONSTRAINT coches_revisiones_fk
FOREIGN KEY (matricula)
REFERENCES Coches (matricula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
