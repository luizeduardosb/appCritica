function msgLive() {
	const toastTrigger = document.getElementById('liveToastBtn')
	const toastLiveExample = document.getElementById('liveToast')

	if (toastTrigger) {
		const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
		toastTrigger.addEventListener('click', () => {
			toastBootstrap.show()
		})
	}
}


$(document).ready(function() {
    $("#cep").blur(function() {
        var cep = $(this).val();

        $.ajax({
            type: "GET",
            url: "https://viacep.com.br/ws/" + cep + "/json/",
            success: function(data) {
                $("#cidade").val(data.localidade);

                $("#uf").val(data.uf);
            },
            error: function() {
                alert("Erro ao buscar o endereço. Verifique o CEP digitado.");
            }
        });
    });
});





