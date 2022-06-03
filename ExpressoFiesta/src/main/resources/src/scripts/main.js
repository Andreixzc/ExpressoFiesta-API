import { Alimento } from "../models/Alimento.js";

const ulAlimentos = document.querySelector(".lista_produtos_produtos");
ulAlimentos.innerHTML = "";

const ulAtracoes = document.querySelector(".lista_produtos_atracoes");
const ulLocais = document.querySelector(".lista_produtos_locais");

for (let i = 0; i < 10; i++) {
  ulAlimentos.appendChild(Alimento.criaContainerAlimento());
}
