document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary

            //TODO dodać info o rodzaju darów w podsumowaniu

            var bagsQty = document.getElementById("quantity").value;
            if (bagsQty != 0) {
                document.querySelector(".summary").querySelector("div").querySelector("li").querySelector("span").nextElementSibling.innerText = 'worków: ' + bagsQty + ' z ';
            } else {
                document.querySelector(".summary").querySelector("div").querySelector("li").querySelector("span").nextElementSibling.innerText = "Nie podano ilości worków"
            }


            const institution = document.querySelector('input[name="institution.id"]:checked').parentElement.querySelector('.title').innerText;
            document.querySelector(".summary").querySelector("div").querySelector("li").nextElementSibling.querySelector("span").nextElementSibling.innerText = 'Dla : ' + institution;

            const street = document.getElementById('street').value;
            if (street) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").innerText = street;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").innerText = "Nie podano ulicy";
            }

            const city = document.getElementById('city').value;
            if (city) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.innerText = city;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.innerText = "Nie podano miasta";
            }

            const zipCode = document.getElementById('zipCode').value;
            if (zipCode) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.nextElementSibling.innerText = zipCode;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.nextElementSibling.innerText = "Nie podano kody pocztowego";
            }

            const phone = document.getElementById('phone').value;
            if (phone) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.nextElementSibling.nextElementSibling.innerText = phone;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.nextElementSibling.nextElementSibling.innerText = "Nie podano telefonu";
            }

            const pickUpDate = document.getElementById('pickUpDate').value;
            if (pickUpDate) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("div").nextElementSibling.querySelector("li").innerText = pickUpDate;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("div").nextElementSibling.querySelector("li").innerText = "Nie podano daty odbioru";
            }

            const pickUpTime = document.getElementById('pickUpTime').value;
            if (pickUpTime) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.innerText = pickUpTime;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.innerText = "Nie podabo godziny odbioru";
            }

            const pickUpComment = document.getElementById('pickUpComment').value;
            if (pickUpComment) {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.nextElementSibling.innerText = pickUpComment;
            } else {
                document.querySelector(".summary").querySelector("div").nextElementSibling.querySelector("div").nextElementSibling.querySelector("li").nextElementSibling.nextElementSibling.innerText = "Brak uwag";
            }
        }
    }

    // TODO - Weryfikacja powtórzenia hasła na stronie - JS
    //
    // var haslo = document.getElementById('password').value;
    // var potwierdzenieHasla = document.getElementById('password2').value;
    //
    // if (haslo !== potwierdzenieHasla) {
    //     alert('Hasła są różne. Proszę wprowadzić takie same hasła.');
    // }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }

});
