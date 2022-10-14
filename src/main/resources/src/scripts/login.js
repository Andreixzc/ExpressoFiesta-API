const urlInsertUser = "https://expresso-fiesta.herokuapp.com/usuario/login";
const formLogin = document.getElementById("form_login_usuario");
formLogin.addEventListener("submit", validar);
function validar(event) {
  event.preventDefault();
  const formDados = new FormData(event.target);
  const novoUsuario = JSON.stringify(Object.fromEntries(formDados));
  formLogin.reset();
  fazPost(novoUsuario);
}
async function fazPost(data) {
  let resultado = await fetch(urlInsertUser, {
    method: "POST",
    body: data,
  })
    .then((res) => res.json())
    .then((res) => {
      if (res.id == 0) throw new Error("Credenciais Inválidas");
      return res;
    })
    .catch((err) => window.alert(err.message));

  delete resultado.senha;
  localStorage.setItem("@CURRENT_USER", JSON.stringify(resultado));

  setTimeout(() => {
    window.location = "/src/Delicious/index.html";
  }, 500);
}
