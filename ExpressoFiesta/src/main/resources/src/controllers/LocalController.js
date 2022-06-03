class LocalController {
  static BASE_URL = "https://festa-api-22.herokuapp.com";

  static async listarLocais() {
    const locais = await fetch(`${this.BASE_URL}/local`)
      .then((res) => res.json())
      .then((res) => res)
      .catch((err) => window.alert(err));

    return locais;
  }

  static async listarUnicoLocal(localId) {
    const localUnico = await fetch(`${this.BASE_URL}/local/${localId}`)
      .then((res) => res.json())
      .then((res) => res)
      .catch((err) => window.alert(err));
    return localUnico;
  }
}

export { LocalController };
