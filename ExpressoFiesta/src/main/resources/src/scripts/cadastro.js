import { UserController } from "../controllers/UserController.js";

const formCadastrar = document.getElementById("form_cadastrar_usuario");
formCadastrar.addEventListener("submit", coletaDados);

async function coletaDados(event) {
  event.preventDefault();

  const formDados = new FormData(event.target);
  const novoUsuario = Object.fromEntries(formDados);
  formCadastrar.reset();

  const statusCadastro = await UserController.cadastrarUsuario(novoUsuario);

  if (statusCadastro.enabled) {
    location.href = "../../login.html";
  }
}
