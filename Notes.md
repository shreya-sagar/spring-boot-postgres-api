Automarshalling
Serialization & DeSerialization
----------------------------------------
Order of Precedence:
1. Command line args
2. SPRING_APPLICATION_JSON args
3. Servlet Parameters
4. JNDI
5. Java System properties
6. OS Environment variables - can be used as main external source
7. Profile properties - can be used as main internal source
8. Application properties - can be used as main internal source
9. @PropertySource annotations
10. Default properties
----------------------------------------
DB_URL, DB_USERNAME, DB_PASSWORD = Set as Environment variables in run configuration in intellij
