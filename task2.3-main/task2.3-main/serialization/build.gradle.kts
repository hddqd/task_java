dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4") // зависимость Jackson для сериализации
    implementation(project(":models")) // зависимость от модуля "models"
    implementation(project(":generator")) // зависимость от модуля "generator"
}

tasks.test {
    useJUnitPlatform()
}