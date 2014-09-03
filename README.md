Java EE Arquillian base project
==========

Small base project consisting of:
- JPA Entity
- Stateless service
- Jax-rs REST webservice

Testing:
- Simple JUnit test
- Arquillian service test
- Arquillian + REST-assured web service test

What you need to get it running:
- Maven and Java + environment variables setup
- JBOSS EAP unzipped http://jbossas.jboss.org/downloads/, note JBOSS root folder path
- Change src/test/resources/arquillian.xml:12 <property name="jbossHome">...</property> to the JBOSS root folder path

How to run:
mvn package -P arq-jbossas-managed
