class Alimento {
  static criaContainerAlimento(data) {
    const card = document.createElement("li");
    card.classList.add("containerProduct");
    // --
    const pdiv = document.createElement("div");
    pdiv.classList.add("productimg");
    const img = document.createElement("img");
    img.src =
      "https://s2.glbimg.com/QNddp3pzuSted92FSuC_sSoi8BQ=/e.glbimg.com/og/ed/f/original/2022/01/19/catnip-gato-felinos-erva_1.png";

    //--
    pdiv.append(img);
    const sdiv = document.createElement("div");
    sdiv.classList.add("productMain");
    const h3 = document.createElement("h3");
    h3.innerText = "Hamburguer";
    const h6 = document.createElement("h6");
    h6.innerText = "R$ 14.00";
    const button = document.createElement("button");
    button.innerText = "Adicionar";
    button.setAttribute("name", "alimento");
    sdiv.append(h3, h6, button);

    button.addEventListener("click", () =>
      this.adicionarAlimentoCart(data, event)
    );

    card.append(pdiv, sdiv);
    return card;
  }

  static adicionarAlimentoCart(data, event) {
    console.log(event.currentTarget);
    console.log(data);
  }
}

export { Alimento };
