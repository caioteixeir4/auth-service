# 🛡️ Auth-Service (Kawashi Sistemas)

Microsserviço de Autenticação e Gestão, construído com **Java 21**, **Spring Boot 3** e **Oracle Database**.

## 🛠️ Tecnologias e Proteções
Este projeto utiliza um "Pipeline de Qualidade" local:
- **Checkstyle (Google)**: Padronização de código.
- **ArchUnit**: Validação de camadas arquiteturais.
- **Jacoco**: Cobertura mínima de 80% de testes.
- **Testcontainers**: Sobe um container Oracle automático para testes unitários.
- **Git Hooks**: Impede nomenclaturas de pastas fora do padrão Java.

## 🚀 Como rodar
1. Tenha o Docker instalado.
2. Execute `./mvnw spring-boot:run`.
3. Acesse o Swagger em: `http://localhost:8080/swagger-ui.html`