# imdb250Filmes
#7DaysOfCode desafio em Java Spring Framework.

Etapa 1 concluída.
Etapa 2 concluída.

Etapa 3 concluída parcialmente. Tive dificuldade para atribuir os valores da lista aos atributos dos objetos. Por enquanto criei uma lista de objetos do tipo Filme para dar continuidade. Criei a classe Filme com todos atributos e a classe dto apenas com os atributos solicitados e imprimi na resposta do Get.

Algumas reflexões: você acha que faz sentido ter setters ou um construtor padrão? Um filme deve ser interfaceado? Deve ser imutável? Justifique a sua decisão no seu repositório.

Concordo que o melhor é criar um construtor para atribuir os valores no ato da criação do objeto. Criei os getters, o construtor vazio também para evitar futuros problemas com a Jpa.

Para quem usa uma versão mais recente do Java, faz sentido usar Records aqui?
Não conhecia, mas olhei o artigo e achei muito interessanto quando usamos classes POJO que é o caso dos Dto's.


