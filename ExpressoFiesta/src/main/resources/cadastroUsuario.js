function validar() {
    let nome = frmUsuario.nome.value;
    let email = frmUsuario.email.value;
    let senha = frmUsuario.senha.value;
    if (nome === "") {
        alert("Preencha o nome");
        frmUsuario.nome.focus();
        return false;
    }else if (email === "") {
        alert("Preencha o email");
        frmUsuario.email.focus();
    }else if (senha === "") {
        alert("Preencha a senha");
        frmUsuario.senha.focus();
    }else{
        document.forms["frmUsuario"].submit();
    }
}