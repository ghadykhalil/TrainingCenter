/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import controllers.InstructorController;
import controllers.SubjectController;
import controllers.SyllabusController;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.text.NumberFormatter;
import models.Instructor;
import models.Subject;
import models.Syllabus;
import models.Chapter;

/**
 *
 * @author User
 */
public class Instructor_Main extends javax.swing.JFrame {

    /**
     * Creates new form Instructor_Main
     */
    public Instructor instructor;

    public Instructor_Main() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Instructor_Main(Instructor instructor) {
        this();
        this.instructor = instructor;
        this.dynamicUsername.setText(instructor.getUsername());
        DefaultListModel<Subject> subjectListModel = new DefaultListModel<>();
        DefaultComboBoxModel<Subject> subjectModelCbx = new DefaultComboBoxModel<>();
        List<Subject> subjects = instructor.getSubjects();
        for (Subject subject : subjects) {
            subjectListModel.addElement(subject);
            subjectModelCbx.addElement(subject);
        }
        prerequisitesList.setModel(subjectListModel);
        allSubjectsList.setModel(subjectListModel);
        selectedSubjectCbx.setModel(subjectModelCbx);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        subjectPanel = new javax.swing.JPanel();
        subjectsLable = new javax.swing.JLabel();
        allsubjectsMainContainer = new javax.swing.JScrollPane();
        allSubjectsList = new javax.swing.JList<>();
        addNewSubject = new javax.swing.JButton();
        subjectNameLabel = new javax.swing.JLabel();
        addNewSubjectLabel = new javax.swing.JLabel();
        subjectNameTxt = new javax.swing.JTextField();
        levelLabel = new javax.swing.JLabel();
        subjectDescriptionTxt = new javax.swing.JTextField();
        prerequisitesLabel = new javax.swing.JLabel();
        allPrerequisitesMainContainer = new javax.swing.JScrollPane();
        prerequisitesList = new javax.swing.JList<>();
        descriptionLabel = new javax.swing.JLabel();
        subjectLvlFormattedTxt = new javax.swing.JFormattedTextField();
        addNewSubject1 = new javax.swing.JButton();
        subjectsLable1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addNewSubjectLabel1 = new javax.swing.JLabel();
        selectedSubjectCbx = new javax.swing.JComboBox<>();
        addNewSubjectLabel2 = new javax.swing.JLabel();
        subjectNameTxt1 = new javax.swing.JTextField();
        addNewSubjectLabel3 = new javax.swing.JLabel();
        subjectNameTxt2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        addNewSubjectLabel4 = new javax.swing.JLabel();
        addNewSubjectLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        syllabusOutput = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        newChapterNameTxt = new javax.swing.JTextField();
        welcomeLabel = new javax.swing.JLabel();
        dynamicUsername = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Instructor");

        subjectsLable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectsLable.setText("All Subjects ");

        allSubjectsList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        allsubjectsMainContainer.setViewportView(allSubjectsList);

        addNewSubject.setText("Add");
        addNewSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSubjectActionPerformed(evt);
            }
        });

        subjectNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectNameLabel.setText("Subject Name");

        addNewSubjectLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addNewSubjectLabel.setText("Add New Subject");

        subjectNameTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameTxtActionPerformed(evt);
            }
        });

        levelLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        levelLabel.setText("Level");

        subjectDescriptionTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectDescriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectDescriptionTxtActionPerformed(evt);
            }
        });

        prerequisitesLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        prerequisitesLabel.setText("Prerequisites ");

        prerequisitesList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        allPrerequisitesMainContainer.setViewportView(prerequisitesList);

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionLabel.setText("Description");

        NumberFormat format = NumberFormat.getIntegerInstance(); // Only integers
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false); // Disallow non-integer input
        formatter.setMinimum(0); // Optional: set a minimum value for integer (e.g., 0)
        formatter.setMaximum(10);
        subjectLvlFormattedTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatter));
        subjectLvlFormattedTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        addNewSubject1.setText("Add Syllabus");
        addNewSubject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSubject1ActionPerformed(evt);
            }
        });

        subjectsLable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectsLable1.setText("Syllabus");

        jLabel2.setText("(Press Subject to see Syllabus)");

        javax.swing.GroupLayout subjectPanelLayout = new javax.swing.GroupLayout(subjectPanel);
        subjectPanel.setLayout(subjectPanelLayout);
        subjectPanelLayout.setHorizontalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addNewSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allPrerequisitesMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addNewSubjectLabel)
                            .addComponent(prerequisitesLabel)
                            .addComponent(subjectLvlFormattedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subjectNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subjectNameTxt)
                            .addComponent(subjectDescriptionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(levelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subjectPanelLayout.createSequentialGroup()
                                .addComponent(subjectsLable)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(216, 216, 216)
                                .addComponent(subjectsLable1))
                            .addGroup(subjectPanelLayout.createSequentialGroup()
                                .addComponent(allsubjectsMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addNewSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(562, Short.MAX_VALUE))
        );
        subjectPanelLayout.setVerticalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addComponent(addNewSubjectLabel)
                        .addGap(18, 18, 18)
                        .addComponent(subjectNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(descriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(levelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subjectLvlFormattedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(prerequisitesLabel))
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subjectsLable)
                            .addComponent(subjectsLable1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allsubjectsMainContainer)
                            .addGroup(subjectPanelLayout.createSequentialGroup()
                                .addComponent(addNewSubject1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allPrerequisitesMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addNewSubject)
                .addGap(26, 26, 26))
        );

        mainTabbedPane.addTab("Subjects", subjectPanel);

        addNewSubjectLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addNewSubjectLabel1.setText("Selected Subject");

        selectedSubjectCbx.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectedSubjectCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedSubjectCbxActionPerformed(evt);
            }
        });

        addNewSubjectLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addNewSubjectLabel2.setText("Brief Description");

        subjectNameTxt1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectNameTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameTxt1ActionPerformed(evt);
            }
        });

        addNewSubjectLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addNewSubjectLabel3.setText("Syllabus Title");

        subjectNameTxt2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subjectNameTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameTxt2ActionPerformed(evt);
            }
        });

        jButton1.setText("Add Syllabus");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addNewSubjectLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addNewSubjectLabel4.setText("Syllabus");

        addNewSubjectLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addNewSubjectLabel5.setText("All Chapters");

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Add Chapter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        syllabusOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        syllabusOutput.setText("Syallbus Existing:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("New Chapter Name");

        newChapterNameTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addNewSubjectLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNewSubjectLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNewSubjectLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectedSubjectCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subjectNameTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(subjectNameTxt2))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addNewSubjectLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(syllabusOutput)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(114, 114, 114)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addNewSubjectLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(828, 828, 828))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(newChapterNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                                .addGap(465, 465, 465))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addNewSubjectLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addNewSubjectLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedSubjectCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(syllabusOutput))
                        .addGap(24, 24, 24)
                        .addComponent(addNewSubjectLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subjectNameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addNewSubjectLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subjectNameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addNewSubjectLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newChapterNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Subject Details", jPanel2);

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        welcomeLabel.setText("Welcome!");

        dynamicUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dynamicUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(446, 446, 446)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logoutButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dynamicUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(mainTabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewSubjectActionPerformed
        // TODO add your handling code here:
        Subject newSubject = new Subject();
        newSubject.setName(subjectNameTxt.getText());
        newSubject.setDesciption(subjectDescriptionTxt.getText());
        newSubject.setLevel(parseInt(subjectLvlFormattedTxt.getText()));
        if (prerequisitesList.getSelectedValuesList() != null) {
            List<Subject> selectedSubjects = prerequisitesList.getSelectedValuesList();
            newSubject.addAllPrerequisites(selectedSubjects);
        }
        instructor.addSubject(newSubject);
        InstructorController.updateInstructor(instructor);
        SubjectController.addSubject(newSubject);
        subjectNameTxt.setText(null);
        subjectDescriptionTxt.setText(null);
        subjectLvlFormattedTxt.setText(null);
        refreshPrerequisitesList();
        refreshSubjectsList();
        refreshSubjectsCbx();
    }//GEN-LAST:event_addNewSubjectActionPerformed

    private void refreshPrerequisitesList() {
        DefaultListModel<Subject> prerequisitesModel = new DefaultListModel<>();
        for (Subject subject : SubjectController.getSubjects()) {
            prerequisitesModel.addElement(subject);
        }
        prerequisitesList.setModel(prerequisitesModel);
    }

    private void refreshSubjectsList() {
        DefaultListModel<Subject> allSubjectsModel = new DefaultListModel<>();
        for (Subject subject : SubjectController.getSubjects()) {
            allSubjectsModel.addElement(subject);
        }
        allSubjectsList.setModel(allSubjectsModel);
    }

    private void refreshSubjectsCbx() {
        DefaultComboBoxModel<Subject> subjectModelCbx = new DefaultComboBoxModel<>();
        for (Subject subject : SubjectController.getSubjects()) {
            subjectModelCbx.addElement(subject);
        }
        selectedSubjectCbx.setModel(subjectModelCbx);
    }


    private void subjectNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectNameTxtActionPerformed

    private void subjectDescriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectDescriptionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectDescriptionTxtActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addNewSubject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewSubject1ActionPerformed
        // TODO add your handling code here:
        selectedSubjectCbx.setSelectedItem(allSubjectsList.getSelectedValue());
        mainTabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_addNewSubject1ActionPerformed

    private void subjectNameTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectNameTxt1ActionPerformed

    private void subjectNameTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectNameTxt2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String syllabusTitle = (String) subjectNameTxt1.getText();
        String syllabusDescription = (String) subjectNameTxt2.getText();
        System.out.println(syllabusTitle);
        System.out.println(syllabusDescription);
        if (selectedSubjectCbx.getSelectedItem() != null
                && !syllabusTitle.isEmpty()
                && !syllabusTitle.isBlank()
                && !syllabusDescription.isEmpty()
                && !syllabusDescription.isBlank()) {
            Subject subject = (Subject) selectedSubjectCbx.getSelectedItem();
            Syllabus syllabus = new Syllabus(syllabusTitle, syllabusDescription);
            subject.setSyllabus(syllabus);

            if (SubjectController.updateSubject(subject)) {
                SyllabusController.addSyllabus(syllabus);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectedSubjectCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedSubjectCbxActionPerformed
        // TODO add your handling code here:
        Subject subjectChangedId = (Subject) selectedSubjectCbx.getSelectedItem();
        Subject subjectChanged = SubjectController.getSubjectById(subjectChangedId.getId());
        Syllabus currentSyllabus = subjectChanged.getSyllabus();
        if (currentSyllabus != null) {
            syllabusOutput.setText(currentSyllabus.getContent());
        }

    }//GEN-LAST:event_selectedSubjectCbxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Subject currentSubject = (Subject) selectedSubjectCbx.getSelectedItem();
        if (selectedSubjectCbx.getSelectedItem() != null) {
            Subject subject = (Subject) selectedSubjectCbx.getSelectedItem();
            Syllabus selectedSyllabus = subject.getSyllabus();
            List<Chapter> allChapters = new ArrayList<>();
            if (selectedSyllabus.getChapters() != null) {
                allChapters = selectedSyllabus.getChapters();
                Chapter chapter = new Chapter(allChapters.size(), newChapterNameTxt.getText());
                selectedSyllabus.add(chapter);
            } else {
                Chapter chapter = new Chapter(1, newChapterNameTxt.getText());
                selectedSyllabus.add(chapter);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Instructor_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instructor_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instructor_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instructor_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instructor_Main().setVisible(true);
            }
        });
    }

    @Override
    public void dispose() {
        instructor.setOnlineStatus(false);
        InstructorController.updateInstructor(instructor);
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewSubject;
    private javax.swing.JButton addNewSubject1;
    private javax.swing.JLabel addNewSubjectLabel;
    private javax.swing.JLabel addNewSubjectLabel1;
    private javax.swing.JLabel addNewSubjectLabel2;
    private javax.swing.JLabel addNewSubjectLabel3;
    private javax.swing.JLabel addNewSubjectLabel4;
    private javax.swing.JLabel addNewSubjectLabel5;
    private javax.swing.JScrollPane allPrerequisitesMainContainer;
    private javax.swing.JList<Subject> allSubjectsList;
    private javax.swing.JScrollPane allsubjectsMainContainer;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel dynamicUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<Chapter> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JTextField newChapterNameTxt;
    private javax.swing.JLabel prerequisitesLabel;
    private javax.swing.JList<Subject> prerequisitesList;
    private javax.swing.JComboBox<Subject> selectedSubjectCbx;
    private javax.swing.JTextField subjectDescriptionTxt;
    javax.swing.JFormattedTextField subjectLvlFormattedTxt;
    private javax.swing.JLabel subjectNameLabel;
    private javax.swing.JTextField subjectNameTxt;
    private javax.swing.JTextField subjectNameTxt1;
    private javax.swing.JTextField subjectNameTxt2;
    private javax.swing.JPanel subjectPanel;
    private javax.swing.JLabel subjectsLable;
    private javax.swing.JLabel subjectsLable1;
    private javax.swing.JLabel syllabusOutput;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
