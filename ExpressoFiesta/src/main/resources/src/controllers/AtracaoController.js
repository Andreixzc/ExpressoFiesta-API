class AtracaoController {
  static BASE_URL = "https://festa-api-22.herokuapp.com";

  static async listarAtracoes() {
    const atracoes = await fetch(`${this.BASE_URL}/atracao`)
      .then((res) => res.json())
      .then((res) => res)
      .catch((err) => window.alert(err));

    return atracoes;
  }

  static async listarUnicaAtracao(atracaoId) {
    const atracaoUnica = await fetch(`${this.BASE_URL}/atracao/${atracaoId}`)
      .then((res) => res.json())
      .then((res) => res)
      .catch((err) => window.alert(err));
    return atracaoUnica;
  }
}

export { AtracaoController };
