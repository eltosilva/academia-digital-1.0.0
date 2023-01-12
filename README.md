# Desáfio de Projeto - DIO

Projeto desenvolvido dentro da [Formação Java Developer](https://web.dio.me/track/81c4cf08-5cef-43f6-a579-1e0158bd9da6) da [DIO](https://www.dio.me/), no **Módulo Conhecendo o Spring Framework**. A atividade tem por titulo **[Conhecendo Spring Data JPA na prática com Java](https://web.dio.me/project/conhecendo-spring-data-jpa-na-pratica-com-java/learning/abd511f0-a5be-4f02-a204-03eb2614a12a?back=/track/formacao-java-developer&tab=undefined&moduleId=undefined)**.

## Descrição

Ao final deste projeto, o Dev irá conhecer os principais conceitos de mapeamento objeto relacional (ORM) usando o Spring Data JPA. Para isso, uma API RESTful será desenvolvida com ênfase na modelagem de suas entidades, no domínio de uma academia de ginástica.
O desáfio é concluir o projeto iniciado pela orientadora e melhora-lo.

## Desenvolvimento Realizado

Além de concluir o projeto, fiz a seguintes alterações:
* Inclui no projeto um handler de execeções para reduzi a verbosidade da mensagem retornada ao usuário, no caso de alteração ou deleção de uma entidade que não exista;
* Criei DTO's para as respostas do endpoints;
* Usei ResponseEntity para gerar os códigos de respostas corretos;