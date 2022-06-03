class PedidoController {
  static BASE_URL = "https://festa-api-22.herokuapp.com";

  static async novoPedido(data) {
    const newPedido = await fetch(`${this.BASE_URL}/pedido/novo`, {
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
        throw new Error("Parâmetros Inválidos");
      })
      .then((res) => res)
      .catch((err) => window.alert(err));
    return newPedido;
  }
}

export { PedidoController };
