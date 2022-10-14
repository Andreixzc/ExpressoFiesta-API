import Model from "../models/LocalModel.js";

const urlGetLocal = "https://expresso-fiesta.herokuapp.com/local/list";

const logout = document.getElementById("logout--");
logout.addEventListener("click", () => {
  localStorage.clear();
  location.href = "../../login.html";
});

if (!localStorage.getItem("@CURRENT_USER")) {
  localStorage.clear();
  location.href = "../../login.html";
}

function data() {
  const resultado = fetch(urlGetLocal)
    .then((res) => res.json())
    .then((res) => {
      res.map((el) => {
        el.quantidade = 1;
        el.secao = "Local";
      });
      return res;
    });
  return resultado;
}

async function createCards() {
  const array = await data();
  array.forEach((elem) => {
    const tabelas = document.getElementById("tabelas");
    tabelas.append(Model.CriaCard(elem));
  });
}

createCards();

const cartLocal = document.getElementById("cart-local");
cartLocal.innerHTML = "";

Model.arrayLocais.forEach((el) => {
  cartLocal.append(Model.modelCarrinhoCard(el));
});
Model.atualizarQuantidadeTotal();
