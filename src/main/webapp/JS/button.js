

document.addEventListener('DOMContentLoaded', () => {
    const numberDisplay = document.getElementById('number');
    const increaseButton = document.getElementById('button');
    const decreaseButton = document.getElementById('button');

    let number = 0;

    increaseButton.addEventListener('click', () => {
        number++;
        numberDisplay.textContent = number;
    });

    decreaseButton.addEventListener('click', () => {
        number--;
        numberDisplay.textContent = number;
    });
});