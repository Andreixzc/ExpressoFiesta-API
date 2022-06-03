import { UserController } from "../controllers/UserController.js";

const formLogin = document.getElementById("form_login_usuario");
formLogin.addEventListener("submit", coletaDados);

async function coletaDados(event) {
  event.preventDefault();

  const formDados = new FormData(event.target);
  const novoLogin = Object.fromEntries(formDados);
  formLogin.reset();

  const statusLogin = await UserController.logarUsuario(novoLogin);
  console.log(statusLogin);
  if (statusLogin.token) {
    location.href = "/src/Delicious/index.html";
  }
}
