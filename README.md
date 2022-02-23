# Simulação de sessão browser

## Problema:
Precisamos desenvolver um endpoint que irá receber uma lista eventos de vários usuários e terá como responsabilidade mapear por usuário a navegabilidade dentro das páginas por sessões e o tempo de navegabilidade entre as páginas. 
## Critérios:
-	Cada sessão tem duração de 10 minutos.
-	Cada usuário tem um id único. 
-	As rotas que foram acessadas dentro da sessão devem ser agrupadas.
-	As rotas agrupadas devem ordenadas do menor para o maior.
-	E deve-se calcular o tempo de navegabilidade das paginas

## Recursos: 
Na raiz do projeto irá conter um arquivo chamado “events.json”, no qual irá conter o payload que deve ser renderizado pelo endpoint.

Exemplo de resposta esperada: 
```json
{
    "sessionsByUser": {
        "65ea4788-6b75-3f7f-aef9-a32f45d39b0f": [
            {
                "pages": [
                    "/preset-afraid-clock/point-wonderful-juice"
                ],
                "duration": 0,
                "startTime": 1515043015151
            },
            {
                "pages": [
                    "/race-wet-way"
                ],
                "duration": 0,
                "startTime": 1515043898490
            },
            {
                "pages": [
                    "/knit-loose-caption/smash-changeable-measure",
                    "/shine-towering-flag"
                ],
                "duration": 247599,
                "startTime": 1515046364586
            }
        ],
        "47084555-1385-34bd-8d8a-3e6646e0da43": [
            {
                "pages": [
                    "/hit-aloof-disease",
                    "/shock-nappy-throat/handwrite-wooden-hen"
                ],
                "duration": 427460,
                "startTime": 1515042110432
            },
            {
                "pages": [
                    "/preset-unsuitable-route"
                ],
                "duration": 0,
                "startTime": 1515043783082
            }
        ]
    }
}
```

