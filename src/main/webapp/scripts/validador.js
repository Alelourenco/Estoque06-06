/** Validação de formulário**/

function validar(){
    let codigo = frmProduto.codigo.value
    let nome = frmProduto.nome.value
    let valor = frmProduto.valor.value
    let quantidade = frmProduto.quantidade.value

    if (codigo === ""){
        alert("Preencha o campo código")
        frmProduto.codigo.focus()
        return false

    } else if (nome === "") {
        alert("Preencha o campo nome")
        frmProduto.nome.focus()
        return false

    } else if (valor === "") {
        alert("Preencha o campo valor")
        frmProduto.valor.focus()
        return false

    } else if (quantidade === "") {
        alert("Preencha o campo quantidade")
        frmProduto.quantidade.focus()
        return false

    } else {
        document.forms["frmProduto"].submit()
    }

}