@echo off

set /p op=Introduce operacion: 

java -cp target/classes es.etg.dam.view.Cliente "%op%"

pause