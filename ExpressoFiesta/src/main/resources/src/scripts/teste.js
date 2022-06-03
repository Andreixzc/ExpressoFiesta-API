import { AlimentoController } from "../controllers/AlimentoController.js";

const produtos = await AlimentoController.listarAlimentos();
console.log(produtos);
