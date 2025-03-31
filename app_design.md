# Hospital Santa Joana - Design do Aplicativo Mobile

## Identidade Visual
- **Cor principal**: Azul escuro (#1E3A8A) - transmitindo profissionalismo e confiança
- **Cores secundárias**: 
  - Azul claro (#3B82F6) - para elementos interativos
  - Cinza claro (#F3F4F6) - para fundos e áreas de conteúdo
  - Branco (#FFFFFF) - para textos e elementos de destaque
  - Verde suave (#10B981) - para confirmações e status positivos
  - Laranja suave (#F59E0B) - para alertas e status em andamento

## Tipografia
- **Fonte principal**: SF Pro Display (iOS) / Roboto (Android)
- **Tamanhos**:
  - Títulos: 24px, negrito
  - Subtítulos: 20px, semi-negrito
  - Corpo: 16px, regular
  - Informações secundárias: 14px, regular
  - Botões: 18px, semi-negrito

## Componentes Reutilizáveis

### Botões
- **Botão primário**: Fundo azul principal (#1E3A8A), texto branco, cantos arredondados (12px), padding vertical 16px
- **Botão secundário**: Borda azul principal, texto azul principal, fundo transparente, cantos arredondados (12px)
- **Botão de ação flutuante**: Circular, azul principal, ícone branco, sombra suave

### Cards
- Fundo branco, cantos arredondados (16px), sombra suave
- Padding interno de 16px
- Espaçamento entre cards: 12px

### Inputs
- Fundo branco, borda cinza claro (#E5E7EB)
- Altura: 56px para fácil toque
- Padding horizontal: 16px
- Cantos arredondados (8px)
- Texto de placeholder em cinza médio (#9CA3AF)

### Ícones
- Linha fina consistente
- Tamanho: 24px para navegação, 20px para ações em cards

## Telas do Aplicativo

### 1. Tela de Login
- Campo para CPF/ID do paciente
- Campo para senha
- Botão "Entrar"
- Link "Esqueci minha senha"
- Opcional: Autenticação biométrica (FaceID/TouchID)

### 2. Tela Inicial (Dashboard)
- Cabeçalho com nome do paciente e número do quarto
- Card de boas-vindas com mensagem personalizada
- Menu de categorias de pedidos com ícones intuitivos
- Resumo da fatura atual
- Atalhos para pedidos recentes ou frequentes
- Ícone de notificações

### 3. Catálogo de Produtos
- Navegação por categorias (Alimentação, Higiene, Conforto, etc.)
- Cards de produtos com:
  - Imagem do produto
  - Nome e descrição curta
  - Preço
  - Botão de adicionar ao carrinho
- Barra de pesquisa no topo
- Filtros de ordenação (preço, popularidade)

### 4. Detalhes do Produto
- Imagem grande do produto
- Nome e descrição completa
- Preço
- Informações adicionais (alérgenos, instruções)
- Seletor de quantidade
- Botão "Adicionar ao Carrinho"

### 5. Carrinho de Pedidos
- Lista de itens com imagem miniatura, nome, quantidade e preço unitário
- Opção de ajustar quantidade ou remover itens
- Subtotal dos itens
- Campo opcional para observações
- Botão "Confirmar Pedido"

### 6. Confirmação de Pedido
- Resumo do pedido
- Mensagem clara indicando que o valor será adicionado à fatura
- Tempo estimado de entrega
- Botão "Finalizar Pedido"
- Animação de confirmação ao finalizar

### 7. Histórico de Pedidos
- Lista de pedidos anteriores organizados por data
- Status visual (Pendente, Em preparo, A caminho, Entregue)
- Cada pedido mostra:
  - Data/hora
  - Itens principais (com opção "ver mais" para listas longas)
  - Valor total
  - Status atual
- Opção de repetir pedido anterior

### 8. Detalhes da Fatura
- Resumo da fatura atual
- Lista de todos os consumos agrupados por dia
- Valor total acumulado
- Informações sobre o processo de pagamento na alta

## Navegação
- Barra inferior com ícones para:
  - Início
  - Catálogo
  - Carrinho (com indicador de quantidade)
  - Pedidos
  - Fatura
- Gestos de swipe entre telas relacionadas
- Botão de voltar consistente no canto superior esquerdo

## Considerações de Acessibilidade
- Alto contraste entre texto e fundo
- Tamanho de toque mínimo de 44x44px para todos elementos interativos
- Suporte a leitor de tela com descrições adequadas
- Opção de aumentar tamanho de fonte
- Feedback tátil e visual para todas as interações
