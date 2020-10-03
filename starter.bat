@echo off
echo "Generating jar file"
call mvn clean install -DskipTests

call discovery\starter.bat

call gateway\starter.bat

call auth\starter.bat

call debts\starter.bat

call consult-cpf\starter.bat

call credit-score\starter.bat