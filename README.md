🚀 Team Workspace & Collaboration Hub (Java Swing OOP Application)

A modern, multi-window desktop application built with Java Swing that demonstrates core Object-Oriented Programming (OOP) principles—specifically inheritance, method overriding, and polymorphism—coupled with a sleek, professional user interface.

✨ Key Features

Object-Oriented Design: Implements a robust class hierarchy with TeamMember as the parent class and LeadContributor as a specialized subclass demonstrating method overriding.

Polymorphic Messaging: Messages sent by lead contributors automatically receive priority tags and custom formatting via polymorphic dispatch.

Modern GUI (Java Swing):

Custom gradient header panels and clean color schemes (Navy & Teal palette).

Real-time participant sidebar tracking active team members.

Styled chat streams supporting timestamps and custom text styling.

Interactive Controls: Dropdowns for role selection, placeholder-supported input fields, and hover-animated action buttons.

🏗️ Project Architecture

The project is structured into clean, separate class files adhering to standard OOP package design:

chatapp/
│
├── TeamMember.java        # Base class representing a standard workspace participant
├── LeadContributor.java   # Subclass demonstrating method overriding (Polymorphism)
└── WorkspaceChatApp.java  # Main application window, GUI layout, and event handlers


🛠️ Prerequisites & Installation

Java Development Kit (JDK 8 or higher) installed on your machine.

Any standard Java IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).

Steps to Run:

Clone this repository or download the source files:

git clone https://github.com/YOUR_USERNAME/team-workspace-chat.git


Place all three .java files (TeamMember.java, LeadContributor.java, and WorkspaceChatApp.java) inside a package folder named chatapp.

Open the project in your favorite IDE.

Run WorkspaceChatApp.java as the main application entry point.

💡 How to Use

Add a Team Member: Enter a member name in the bottom input bar, choose their role (e.g., Developer, Lead Engineer, UI/UX Designer), and click + Add Member.

View Active Participants: Newly added members will instantly appear in the left sidebar with status indicators.

Broadcast Messages: Select a sender from the sender dropdown, type your message, and click Send Message to publish it to the live project stream.

🛡️ License

This project is developed for academic coursework and professional portfolio demonstration. Feel free to use and adapt for learning purposes.
