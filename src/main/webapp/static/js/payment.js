console.log("payment.js working")

async function getApi(url) {
    let response = await fetch(url);
    if (response.ok) {
        return await response.json();
    } else {
        console.log(response.statusText);
        return [];
    }
}

