const API_URL = "http://localhost:8080/altacommerce/api/v1/login";

const form = document.getElementById("loginForm");
const mensagem = document.getElementById("mensagem");
const btnRefresh = document.getElementById("btnRefresh");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const login = document.getElementById("login").value;
    const senha = document.getElementById("senha").value;

    mensagem.textContent = "Autenticando...";
    mensagem.className = "text-primary";

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ login, senha })
        });

        if (!response.ok) {
            throw new Error("Credenciais inválidas");
        }

        const data = await response.json();

        localStorage.setItem("accessToken", data.tokenAcesso);
        localStorage.setItem("refreshToken", data.refreshToken);

        mensagem.textContent = "Login realizado com sucesso ✅";
        mensagem.className = "text-success";

        console.log("Access Token:", data.tokenAcesso);
        console.log("Refresh Token:", data.refreshToken);

    } catch (error) {
        mensagem.textContent = "Erro ao realizar login ❌";
        mensagem.className = "text-danger";
        console.error(error);
    }
});

btnRefresh.addEventListener("click", async () => {
    const refreshToken = localStorage.getItem("refreshToken");

    if (!refreshToken) {
        mensagem.textContent = "Nenhum refresh token encontrado";
        mensagem.className = "text-warning";
        return;
    }

    mensagem.textContent = "Atualizando token...";
    mensagem.className = "text-primary";

    try {
        const response = await fetch(`${API_URL}/atualizar-token`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ refreshToken })
        });

        if (!response.ok) {
            throw new Error("Erro ao atualizar token");
        }

        const data = await response.json();

        localStorage.setItem("accessToken", data.tokenAcesso);
        localStorage.setItem("refreshToken", data.refreshToken);

        mensagem.textContent = "Token atualizado com sucesso 🔄";
        mensagem.className = "text-success";

        console.log("Novo Access Token:", data.tokenAcesso);

    } catch (error) {
        mensagem.textContent = "Erro ao atualizar token ❌";
        mensagem.className = "text-danger";
        console.error(error);
    }
});
