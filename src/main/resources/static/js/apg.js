document.addEventListener('DOMContentLoaded', () => {
    const backButton = document.querySelector('.js-back-button');
    const serviceTypeButtonsContainer = document.querySelector('.js-service-type-buttons-container');
    const serviceTypeButtons = document.querySelectorAll('.js-service-type-button');
    const printPasswordForm = document.querySelector('.js-print-password-form');
    const serviceTypeInput = document.querySelector('.js-service-type-input');
    const passwordTypeInput = document.querySelector('.js-password-type-input');
    const loading = document.querySelector('.js-loading');
    const displayNoneClass = 'apg-display-none';
    const visibilityHiddenClass = 'apg-visibility-hidden';

    backButton.addEventListener('click', () => {
        backButton.classList.add(visibilityHiddenClass);
        printPasswordForm.classList.add(displayNoneClass);
        serviceTypeButtonsContainer.classList.remove(displayNoneClass);
    });

    serviceTypeButtons.forEach(serviceTypeButton => {
        const { inputValue } = serviceTypeButton.dataset;

        serviceTypeButton.addEventListener('click', () => {
            serviceTypeInput.value = inputValue;

            serviceTypeButtonsContainer.classList.add(displayNoneClass);
            printPasswordForm.classList.remove(displayNoneClass);
            backButton.classList.remove(visibilityHiddenClass);
        });
    });

    printPasswordForm.addEventListener('submit', (event) => {
        event.preventDefault();

        loading.classList.remove(displayNoneClass);

        const passwordTypeButtonClicked = event.submitter;
        const { inputValue } = passwordTypeButtonClicked.dataset;

        passwordTypeInput.value = inputValue;

        printPasswordForm.submit();
    });
});
