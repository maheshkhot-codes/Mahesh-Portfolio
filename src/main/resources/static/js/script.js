// ======================================================
// PORTFOLIO JAVASCRIPT
// Mahesh Khot | Software Engineer
// ======================================================


// ======================================================
// ELEMENTS
// ======================================================

const sections = document.querySelectorAll("section");
const navLinks = document.querySelectorAll(".navbar a");
const scrollDown = document.querySelector(".scroll-down");
const contactForm = document.getElementById("contact-form");


// ======================================================
// ACTIVE NAVIGATION WHILE SCROLLING
// ======================================================

function updateActiveNavigation() {

    let currentSection = "";

    const scrollPosition = window.scrollY + 250;

    sections.forEach((section) => {

        const sectionTop = section.offsetTop;
        const sectionHeight = section.offsetHeight;

        if (
            scrollPosition >= sectionTop &&
            scrollPosition < sectionTop + sectionHeight
        ) {
            currentSection = section.getAttribute("id");
        }

    });


    navLinks.forEach((link) => {

        link.classList.remove("active");

        const linkTarget = link.getAttribute("href");

        if (linkTarget === "#" + currentSection) {
            link.classList.add("active");
        }

    });

}


// Run when page is scrolled
window.addEventListener("scroll", updateActiveNavigation);

// Run once when page loads
window.addEventListener("load", updateActiveNavigation);


// ======================================================
// SMOOTH NAVIGATION
// ======================================================

navLinks.forEach((link) => {

    link.addEventListener("click", function (event) {

        const targetId = this.getAttribute("href");

        if (!targetId || !targetId.startsWith("#")) {
            return;
        }

        const targetSection = document.querySelector(targetId);

        if (!targetSection) {
            return;
        }

        event.preventDefault();

        targetSection.scrollIntoView({
            behavior: "smooth",
            block: "start"
        });

    });

});


// ======================================================
// SCROLL DOWN BUTTON
// ======================================================

if (scrollDown) {

    scrollDown.addEventListener("click", function (event) {

        const targetId = this.getAttribute("href");

        if (!targetId) {
            return;
        }

        const targetSection = document.querySelector(targetId);

        if (!targetSection) {
            return;
        }

        event.preventDefault();

        targetSection.scrollIntoView({
            behavior: "smooth",
            block: "start"
        });

    });

}


// ======================================================
// CONTACT FORM
// ======================================================

if (contactForm) {

    contactForm.addEventListener("submit", async function (event) {

        event.preventDefault();

        // Get fields using their NAME attributes
        const nameInput =
            contactForm.querySelector('input[name="name"]');

        const emailInput =
            contactForm.querySelector('input[name="email"]');

        const messageInput =
            contactForm.querySelector('textarea[name="message"]');


        // Make sure fields exist
        if (!nameInput || !emailInput || !messageInput) {

            console.error("Contact form fields not found.");

            alert("Contact form error. Please refresh the page.");

            return;
        }


        // Get values
        const name = nameInput.value.trim();
        const email = emailInput.value.trim();
        const message = messageInput.value.trim();


        // Validate fields
        if (!name || !email || !message) {

            alert("Please fill in all the fields.");

            return;
        }


        // Validate email
        const emailPattern =
            /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailPattern.test(email)) {

            alert("Please enter a valid email address.");

            return;
        }


        // Get submit button
        const submitButton =
            contactForm.querySelector('button[type="submit"]');


        // Disable button
        if (submitButton) {

            submitButton.disabled = true;

            submitButton.innerHTML = "Sending...";

        }


        try {

            // Send data to Spring Boot
            const response = await fetch("/api/contact", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify({

                    name: name,

                    email: email,

                    message: message

                })

            });


            const result = await response.text();


            // Backend returned success
            if (response.ok) {

                alert(
                    "Message sent successfully! Thank you for contacting me."
                );

                contactForm.reset();

            }

            // Backend returned error
            else {

                console.error(
                    "Server error:",
                    response.status,
                    result
                );

                alert(
                    "Failed to send message. Please try again."
                );

            }


        } catch (error) {

            console.error(
                "Error connecting to backend:",
                error
            );

            alert(
                "Unable to connect to the server."
            );

        }


        // Enable button again
        finally {

            if (submitButton) {

                submitButton.disabled = false;

                submitButton.innerHTML =
                    'Send Message <i class="fa-solid fa-paper-plane"></i>';

            }

        }

    });

}


// ======================================================
// REVEAL SECTIONS WHEN SCROLLING
// ======================================================

const revealElements = document.querySelectorAll(
    ".section-title, " +
    ".about-container, " +
    ".skill-box, " +
    ".project-card, " +
    ".contact-container"
);


const revealObserver = new IntersectionObserver(

    (entries, observer) => {

        entries.forEach((entry) => {

            if (entry.isIntersecting) {

                entry.target.classList.add("show");

                observer.unobserve(entry.target);

            }

        });

    },

    {
        threshold: 0.12
    }

);


revealElements.forEach((element) => {

    element.classList.add("reveal");

    revealObserver.observe(element);

});


// ======================================================
// PREVENT BROKEN IMAGE DISPLAY
// ======================================================

const images = document.querySelectorAll("img");

images.forEach((image) => {

    image.addEventListener("error", function () {

        this.style.display = "none";

    });

});


// ======================================================
// UPDATE ACTIVE NAVIGATION AFTER CLICK
// ======================================================

navLinks.forEach((link) => {

    link.addEventListener("click", function () {

        navLinks.forEach((item) => {

            item.classList.remove("active");

        });

        this.classList.add("active");

    });

});


// ======================================================
// TYPEWRITER NAME
// ======================================================

document.addEventListener("DOMContentLoaded", function () {

    const textElement =
        document.getElementById("typing-text");


    if (!textElement) {

        console.log("typing-text element not found");

        return;

    }


    const text = "Mahesh Khot";

    let index = 0;

    let deleting = false;


    function typeWriter() {

        if (!deleting) {

            // Type
            textElement.textContent =
                text.substring(0, index + 1);

            index++;


            if (index === text.length) {

                deleting = true;

                // Wait after completing the name
                setTimeout(typeWriter, 1500);

            }

            else {

                // Typing speed
                setTimeout(typeWriter, 220);

            }

        }

        else {

            // Delete
            textElement.textContent =
                text.substring(0, index - 1);

            index--;


            if (index === 0) {

                deleting = false;

                // Wait before typing again
                setTimeout(typeWriter, 500);

            }

            else {

                // Deleting speed
                setTimeout(typeWriter, 150);

            }

        }

    }


    typeWriter();

});


// ======================================================
// INITIALIZATION
// ======================================================

document.addEventListener("DOMContentLoaded", function () {

    updateActiveNavigation();

});