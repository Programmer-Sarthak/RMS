

    document.addEventListener('DOMContentLoaded', () => {
        const numberDisplay = document.getElementById('number');
        const increaseButton = document.getElementById('increase');
        const decreaseButton = document.getElementById('decrease');

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