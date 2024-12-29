document.addEventListener('DOMContentLoaded', () => {
  let cartItems = [];
  let totalPrice = 0;


  fetch('/products')
    .then(response => response.json())
    .then(data => {
      data.forEach(card => {
        var cardHtml = `
          <div class="col-3 mb-5">
            <div class="card" style="width: 18rem;">
              <img src="images/${card.imagePath}" class="card-img-top" alt="..." width="250px" height="250px">
              <div class="card-body">
                <h5 class="card-title">${card.name}</h5>
                <p class="card-text">$ ${card.price}</p>
                <button class="btn btn-warning add-to-cart text-white" data-name="${card.name}" data-price="${card.price}">Add to cart</button>
              </div>
            </div>
          </div>
        `;
        document.getElementById('card-container').innerHTML += cardHtml;
      });


      document.querySelectorAll('.add-to-cart').forEach(button => {
        button.addEventListener('click', (event) => {
          const productName = event.target.getAttribute('data-name');
          const productPrice = parseFloat(event.target.getAttribute('data-price'));

            alert(`${productName} has been added!`);


          cartItems.push(productName);
          totalPrice += productPrice;
        });
      });
    })
    .catch(error => console.error('Error while fetching products!', error));


  document.getElementById('place-order').addEventListener('click', () => {

    const forma = document.getElementById('forma');
    forma.style.display = 'block';
  });


  const checkoutForm = document.getElementById('checkout-form');
  if (checkoutForm) {
    checkoutForm.addEventListener('submit', (event) => {
      event.preventDefault();

      const name = document.getElementById('name').value;
      const address = document.getElementById('address').value;


      const orderData = {
        items: cartItems.join(', '),
        price: totalPrice,
        name: name,
        address: address
      };


      fetch('/checkout', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(orderData)
      })
        alert('Purchase successful!');
        cartItems = [];
        totalPrice = 0;
    });
  }
});
