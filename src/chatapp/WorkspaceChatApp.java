/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author pramo
 */


import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WorkspaceChatApp extends JFrame {
    
    ArrayList<TeamMember> teamMembers = new ArrayList<>();

    JTextField nameField;
    JTextField messageField;
    JComboBox<String> roleBox;
    JComboBox<String> senderDropdown;
    JPanel memberListPanel;
    JTextPane messageArea;
    JLabel memberCountLabel;

    Color navyBlue = new Color(30, 41, 59);
    Color slateDark = new Color(15, 23, 42);
    Color tealAccent = new Color(13, 148, 136);
    Color tealLight = new Color(204, 251, 241);
    Color bgLight = new Color(248, 250, 252);
    Color white = Color.WHITE;
    Color textDark = new Color(51, 65, 85);
    Color textMuted = new Color(100, 116, 139);

    public WorkspaceChatApp() {
        setTitle("Team Workspace & Collaboration Hub");
        setSize(1250, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildUserInterface();
    }

    public void buildUserInterface() {
        JPanel mainLayout = new JPanel(new BorderLayout());
        mainLayout.setBackground(bgLight);

        // --- TOP HEADER ---
        JPanel headerPanel = new GradientHeaderPanel(navyBlue, slateDark);
        headerPanel.setPreferredSize(new Dimension(1250, 130));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(20, 35, 20, 35));

        JLabel titleLabel = new JLabel("TEAM COLLABORATION PORTAL");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(white);

        JLabel subtitleLabel = new JLabel("Real-time project sync & discussion");
        subtitleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(203, 213, 225));

        JPanel titleTextGroup = new JPanel();
        titleTextGroup.setOpaque(false);
        titleTextGroup.setLayout(new BoxLayout(titleTextGroup, BoxLayout.Y_AXIS));
        titleTextGroup.add(titleLabel);
        titleTextGroup.add(Box.createVerticalStrut(4));
        titleTextGroup.add(subtitleLabel);

        JLabel statusBadge = new JLabel(" LIVE SYNC ");
        statusBadge.setFont(new Font("Segoe UI", Font.BOLD, 14));
        statusBadge.setForeground(white);
        statusBadge.setOpaque(true);
        statusBadge.setBackground(tealAccent);
        statusBadge.setBorder(new CompoundBorder(
            new LineBorder(white, 2, true),
            new EmptyBorder(8, 16, 8, 16)
        ));

        headerPanel.add(titleTextGroup, BorderLayout.WEST);
        headerPanel.add(statusBadge, BorderLayout.EAST);
        mainLayout.add(headerPanel, BorderLayout.NORTH);

        // --- CENTER WORKSPACE AREA ---
        JPanel centerArea = new JPanel(new BorderLayout(15, 15));
        centerArea.setBackground(bgLight);
        centerArea.setBorder(new EmptyBorder(15, 20, 15, 20));

        // Left Sidebar: Participants
        JPanel sidebarPanel = new JPanel(new BorderLayout());
        sidebarPanel.setBackground(white);
        sidebarPanel.setPreferredSize(new Dimension(300, 0));
        sidebarPanel.setBorder(new CompoundBorder(
            new LineBorder(new Color(226, 232, 240), 2, true),
            new EmptyBorder(0, 0, 10, 0)
        ));

        JPanel sideHeader = new GradientHeaderPanel(tealAccent, navyBlue);
        sideHeader.setLayout(new BorderLayout());
        sideHeader.setBorder(new EmptyBorder(16, 20, 16, 16));

        JLabel sideTitle = new JLabel("Team Members");
        sideTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        sideTitle.setForeground(white);

        memberCountLabel = new JLabel("0");
        memberCountLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        memberCountLabel.setForeground(white);
        memberCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        memberCountLabel.setOpaque(true);
        memberCountLabel.setBackground(new Color(15, 23, 42, 150));
        memberCountLabel.setPreferredSize(new Dimension(35, 35));
        memberCountLabel.setBorder(new LineBorder(white, 1, true));

        sideHeader.add(sideTitle, BorderLayout.WEST);
        sideHeader.add(memberCountLabel, BorderLayout.EAST);
        sidebarPanel.add(sideHeader, BorderLayout.NORTH);

        memberListPanel = new JPanel();
        memberListPanel.setLayout(new BoxLayout(memberListPanel, BoxLayout.Y_AXIS));
        memberListPanel.setBackground(white);
        memberListPanel.setBorder(new EmptyBorder(12, 12, 12, 12));

        JScrollPane memberScroll = new JScrollPane(memberListPanel);
        memberScroll.setBorder(null);
        sidebarPanel.add(memberScroll, BorderLayout.CENTER);

        JLabel footerNote = new JLabel("Collaborate securely in real-time");
        footerNote.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        footerNote.setForeground(textMuted);
        footerNote.setHorizontalAlignment(SwingConstants.CENTER);
        footerNote.setBorder(new EmptyBorder(12, 10, 12, 10));
        footerNote.setOpaque(true);
        footerNote.setBackground(tealLight);
        sidebarPanel.add(footerNote, BorderLayout.SOUTH);

        centerArea.add(sidebarPanel, BorderLayout.WEST);

        
        JPanel chatContainer = new JPanel(new BorderLayout());
        chatContainer.setBackground(white);
        chatContainer.setBorder(new LineBorder(new Color(226, 232, 240), 2, true));

        JPanel chatHeaderBar = new JPanel(new BorderLayout());
        chatHeaderBar.setBackground(new Color(241, 245, 249));
        chatHeaderBar.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel chatHeaderTitle = new JLabel("Project Discussion Stream");
        chatHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        chatHeaderTitle.setForeground(textDark);

        JLabel clockLabel = new JLabel(new SimpleDateFormat("EEE, dd MMM yyyy | hh:mm a").format(new Date()));
        clockLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        clockLabel.setForeground(textMuted);

        chatHeaderBar.add(chatHeaderTitle, BorderLayout.WEST);
        chatHeaderBar.add(clockLabel, BorderLayout.EAST);
        chatContainer.add(chatHeaderBar, BorderLayout.NORTH);

        messageArea = new JTextPane();
        messageArea.setEditable(false);
        messageArea.setBackground(new Color(252, 252, 253));
        messageArea.setBorder(new EmptyBorder(15, 20, 15, 20));

        JScrollPane chatScroll = new JScrollPane(messageArea);
        chatScroll.setBorder(null);
        chatContainer.add(chatScroll, BorderLayout.CENTER);

        appendWelcomeMessage();
        centerArea.add(chatContainer, BorderLayout.CENTER);
        mainLayout.add(centerArea, BorderLayout.CENTER);

        // --- BOTTOM CONTROLS PANEL ---
        JPanel bottomControlPanel = new JPanel(new BorderLayout());
        bottomControlPanel.setBackground(new Color(241, 245, 249));
        bottomControlPanel.setBorder(new EmptyBorder(15, 25, 20, 25));

        // Add Member Row
        JPanel addMemberRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        addMemberRow.setOpaque(false);

        nameField = new JTextField("Enter member name...");
        setupFieldPlaceholder(nameField, "Enter member name...");
        nameField.setPreferredSize(new Dimension(220, 40));
        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        String[] roles = {"Developer", "Lead Engineer", "UI/UX Designer", "QA Analyst"};
        roleBox = new JComboBox<>(roles);
        roleBox.setPreferredSize(new Dimension(150, 40));
        roleBox.setFont(new Font("Segoe UI", Font.BOLD, 13));

        JButton addMemberBtn = createStyledButton("+ Add Member", tealAccent);

        addMemberRow.add(new JLabel("New Member:"));
        addMemberRow.add(nameField);
        addMemberRow.add(roleBox);
        addMemberRow.add(addMemberBtn);
        bottomControlPanel.add(addMemberRow, BorderLayout.NORTH);

        // Send Message Row
        JPanel sendMessageRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        sendMessageRow.setOpaque(false);

        senderDropdown = new JComboBox<>();
        senderDropdown.setPreferredSize(new Dimension(180, 40));
        senderDropdown.setFont(new Font("Segoe UI", Font.BOLD, 13));

        messageField = new JTextField("Type your broadcast message here...");
        setupFieldPlaceholder(messageField, "Type your broadcast message here...");
        messageField.setPreferredSize(new Dimension(420, 40));
        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton sendBtn = createStyledButton("Send Message", navyBlue);

        sendMessageRow.add(new JLabel("Sender:"));
        sendMessageRow.add(senderDropdown);
        sendMessageRow.add(messageField);
        sendMessageRow.add(sendBtn);
        bottomControlPanel.add(sendMessageRow, BorderLayout.SOUTH);

        mainLayout.add(bottomControlPanel, BorderLayout.SOUTH);

        // Event Listeners
        addMemberBtn.addActionListener(e -> registerNewMember());
        nameField.addActionListener(e -> registerNewMember());
        sendBtn.addActionListener(e -> broadcastMessage());
        messageField.addActionListener(e -> broadcastMessage());

        setContentPane(mainLayout);
    }

    private void setupFieldPlaceholder(JTextField field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(textDark);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(textMuted);
                }
            }
        });
        field.setForeground(textMuted);
    }

    private JButton createStyledButton(String text, Color backgroundCol) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(white);
        button.setBackground(backgroundCol);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(10, 18, 10, 18));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(backgroundCol.darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(backgroundCol);
            }
        });
        return button;
    }

    public void registerNewMember() {
        String memberName = nameField.getText().trim();
        String selectedRole = (String) roleBox.getSelectedItem();
        String defaultPlaceholder = "Enter member name...";

        if (memberName.equals(defaultPlaceholder) || memberName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid member name.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (TeamMember m : teamMembers) {
            if (m.getName().equalsIgnoreCase(memberName)) {
                JOptionPane.showMessageDialog(this, "A member with this name already exists.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        TeamMember newMember;
        if ("Lead Engineer".equals(selectedRole)) {
            newMember = new LeadContributor(memberName, selectedRole);
        } else {
            newMember = new TeamMember(memberName, selectedRole);
        }

        teamMembers.add(newMember);
        senderDropdown.addItem(memberName);
        refreshMemberListUI();

        nameField.setText("");
        JOptionPane.showMessageDialog(this, memberName + " has joined the workspace session!", "Session Update", JOptionPane.INFORMATION_MESSAGE);
    }

    public void refreshMemberListUI() {
        memberListPanel.removeAll();
        for (TeamMember m : teamMembers) {
            memberListPanel.add(createMemberCard(m.getName(), m.getRole()));
            memberListPanel.add(Box.createVerticalStrut(8));
        }
        memberCountLabel.setText(String.valueOf(teamMembers.size()));
        memberListPanel.revalidate();
        memberListPanel.repaint();
    }

    public JPanel createMemberCard(String name, String role) {
        JPanel card = new JPanel(new BorderLayout(10, 0));
        card.setBackground(new Color(248, 250, 252));
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(203, 213, 225), 1, true),
            new EmptyBorder(10, 10, 10, 10)
        ));

        JLabel avatarIcon = new JLabel("👤");
        avatarIcon.setFont(new Font("Segoe UI", Font.PLAIN, 24));

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel nameLbl = new JLabel(name);
        nameLbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nameLbl.setForeground(textDark);

        JLabel roleLbl = new JLabel(role + " • Online");
        roleLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        roleLbl.setForeground(new Color(13, 148, 136));

        infoPanel.add(nameLbl);
        infoPanel.add(roleLbl);

        card.add(avatarIcon, BorderLayout.WEST);
        card.add(infoPanel, BorderLayout.CENTER);
        return card;
    }

    public void broadcastMessage() {
        int selectedIndex = senderDropdown.getSelectedIndex();
        String rawMessage = messageField.getText().trim();
        String placeholderText = "Type your broadcast message here...";

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please add and select a team member first.", "No Sender", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (rawMessage.equals(placeholderText) || rawMessage.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Message cannot be empty.", "Empty Message", JOptionPane.WARNING_MESSAGE);
            return;
        }

        TeamMember activeSender = teamMembers.get(selectedIndex);
        String formattedOutput = activeSender.formatMessage(rawMessage);

        appendChatMessage(activeSender.getName(), formattedOutput, new SimpleDateFormat("hh:mm a").format(new Date()));

        messageField.setText("");
        messageField.requestFocus();
    }

    public void appendChatMessage(String senderName, String fullMessageContent, String timestamp) {
        StyledDocument doc = messageArea.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), "\n", null);

            SimpleAttributeSet nameStyle = new SimpleAttributeSet();
            StyleConstants.setFontFamily(nameStyle, "Segoe UI");
            StyleConstants.setFontSize(nameStyle, 15);
            StyleConstants.setBold(nameStyle, true);
            StyleConstants.setForeground(nameStyle, tealAccent);
            doc.insertString(doc.getLength(), " ➔ " + senderName, nameStyle);

            SimpleAttributeSet timeStyle = new SimpleAttributeSet();
            StyleConstants.setFontFamily(timeStyle, "Segoe UI");
            StyleConstants.setFontSize(timeStyle, 11);
            StyleConstants.setForeground(timeStyle, textMuted);
            doc.insertString(doc.getLength(), "  [" + timestamp + "]\n", timeStyle);

            SimpleAttributeSet bodyStyle = new SimpleAttributeSet();
            StyleConstants.setFontFamily(bodyStyle, "Segoe UI");
            StyleConstants.setFontSize(bodyStyle, 14);
            StyleConstants.setForeground(bodyStyle, textDark);
            doc.insertString(doc.getLength(), "    " + fullMessageContent + "\n", bodyStyle);

            SimpleAttributeSet dividerStyle = new SimpleAttributeSet();
            StyleConstants.setForeground(dividerStyle, new Color(226, 232, 240));
            doc.insertString(doc.getLength(), "    ──────────────────────────────────────────\n", dividerStyle);

            messageArea.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void appendWelcomeMessage() {
        StyledDocument doc = messageArea.getStyledDocument();
        try {
            SimpleAttributeSet titleStyle = new SimpleAttributeSet();
            StyleConstants.setAlignment(titleStyle, StyleConstants.ALIGN_CENTER);
            StyleConstants.setFontFamily(titleStyle, "Segoe UI");
            StyleConstants.setFontSize(titleStyle, 20);
            StyleConstants.setBold(titleStyle, true);
            StyleConstants.setForeground(titleStyle, navyBlue);
            doc.insertString(doc.getLength(), "\nWelcome to the Team Collaboration Hub!\n\n", titleStyle);

            SimpleAttributeSet descStyle = new SimpleAttributeSet();
            StyleConstants.setAlignment(descStyle, StyleConstants.ALIGN_CENTER);
            StyleConstants.setFontFamily(descStyle, "Segoe UI");
            StyleConstants.setFontSize(descStyle, 14);
            StyleConstants.setForeground(descStyle, textMuted);
            doc.insertString(doc.getLength(), "Add team members using the panel below to start broadcasting updates.\nAll active participants will see messages in real time.", descStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    static class GradientHeaderPanel extends JPanel {
        private Color startColor;
        private Color endColor;

        public GradientHeaderPanel(Color startColor, Color endColor) {
            this.startColor = startColor;
            this.endColor = endColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
            g2.setPaint(gradient);
            g2.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WorkspaceChatApp app = new WorkspaceChatApp();
            app.setVisible(true);
        });
    }
}
