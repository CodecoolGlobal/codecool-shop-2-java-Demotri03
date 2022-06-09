async function getApi(url) {
    let response = await fetch(url);
    if (response.ok) {
        return await response.json();
    } else {
        console.log(response.statusText);
        return [];
    }
}

let accountNrInput = document.getElementById("accountNr");
let payBtn = document.getElementById("pay");
let confirm = document.getElementById("confirm");
let paymentCard = document.getElementById("payment-container");

payBtn.addEventListener("click", async () => {
    let number = accountNrInput.value;
    response = await getApi(`/order/payment/confirm?account=${number}`)
    console.log(response)
  setConfirmation(response);

    }
)

    function setConfirmation(code) {
        switch (code) {
            case 1:
                confirm.innerHTML = "Order succesfull";
                paymentCard.remove();
                break;
            case 5:
                confirm.innerHTML = "Wrong account number";
                break;
            default:
                confirm.innerHTML = "Payment failed"
        }

}







