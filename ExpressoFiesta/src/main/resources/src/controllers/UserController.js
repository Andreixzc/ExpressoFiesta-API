class UserController {
  static BASE_URL = "https://festa-api-22.herokuapp.com";

  static async cadastrarUsuario(data) {
    const url = `${this.BASE_URL}/usuario`;
    const novoUsuario = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((res) => {
        if (res.status == 200) {
          return res.json();
        }
        throw new Error("Valores inválidos");
      })
      .then((res) => res)
      .catch((err) => window.alert(err));
    return novoUsuario;
  }

  static async logarUsuario(data) {
    const novoLogin = await fetch(`${this.BASE_URL}/auth`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((res) => {
        if (res.status == 200) {
          return res.json();
        }
        throw new Error("Valores inválidos");
      })
      .then((res) => res)
      .catch((err) => window.alert(err));
    return novoLogin;
  }
}

export { UserController };
