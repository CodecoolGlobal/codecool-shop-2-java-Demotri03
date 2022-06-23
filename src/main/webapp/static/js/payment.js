async function getApi(url) {
    let response = await fetch(url);
    if (response.ok) {
        return await response.json();
    } else {
        console.log(response.statusText);
        return [];
    }
}


let confirm = document.getElementById("confirm");
let paymentCard = document.getElementById("payment-container");
let firstNameInput = document.getElementById("first-name");
let lastNameInput = document.getElementById("last-name");

let cityLineInput = document.getElementById("city");
let streetInput = document.getElementById("house-number");
let houseNumberInput = document.getElementById("last-name");
let zipCodeInput = document.getElementById("zip");
let cardNumberInput = document.getElementById("cc-number");
let nameOnCardInput = document.getElementById("cc-name");
let cardExpirationInput = document.getElementById("cc-expiration");
let cvvInput = document.getElementById("cc-cvv")
let countryInput = document.getElementById("country");

confirm.addEventListener("click", ()=>
    async () => {
        let firstName = firstNameInput.value;
        let lastName = lastNameInput.value;
        let country = countryInput.value;
        let city = cityLineInput.value
        let street = streetInput.value;
        let houseNumber = houseNumberInput.value;
        let zipCode = zipCodeInput.value;
        let cardNumber = cardNumberInput.value;
        let nameOnCard = nameOnCardInput.value;
        let cardExpiration = cardExpirationInput.value;
        let cvv = cvvInput.value;

        response = await getApi(`/order/payment/confirm?first-name=${firstName}&last-name=${lastName
        }&country=${country}&city=${city}&street=${street}&house-number=${houseNumber}&zipcode=${zipCode}&card-number=${cardNumber}
        &name-on-card=${nameOnCard}&card-exp=${cardExpiration}&cvv=${cvv}`)

        console.log(response)
        setConfirmation(response);}

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







