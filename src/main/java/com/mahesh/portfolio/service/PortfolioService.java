package com.mahesh.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahesh.portfolio.model.Project;

@Service
public class PortfolioService {

    // ================================
    // PROJECTS
    // ================================

    public List<Project> getProjects() {

        return List.of(

            new Project(
                "WealthWise – Mutual Fund & SIP Tracking Platform",
                "Full-stack application for mutual fund investment simulation and SIP tracking.",
                "Core Java, Spring Boot, React.js, MySQL, REST APIs",
                "/images/project1.jpg",
                "https://github.com/maheshkhot-codes/wealthwise-mutual-fund-management-system",
                "#"
            ),

            new Project(
                "AI Recruitment System",
                "AI-powered recruitment platform for semantic job matching, resume parsing and candidate ranking.",
                "Python, FastAPI, React.js, FAISS, XGBoost",
                "/images/project2.jpg",
                "https://github.com/maheshkhot-codes",
                "#"
            ),

            new Project(
                "AI-Powered Predictive Maintenance System",
                "AI-based industrial system that predicts equipment failure using machine learning.",
                "Python, LSTM, Flask, Machine Learning, Plotly",
                "/images/project3.jpg",
                "https://github.com/maheshkhot-codes/Predictive-Maintenance-LSTM",
                "#"
            )

        );
    }


    // ================================
    // INTERNSHIP
    // ================================

    public Project getInternship() {

        return new Project(
            "Python & AI Intern",
            "Genplus Training & Consulting Services Pvt. Ltd.\n\n" +
            "February – May\n\n" +
            "Worked on Python programming, machine learning concepts, " +
            "model training and evaluation. Gained hands-on experience " +
            "with machine learning libraries and developed an " +
            "AI-based Recruitment System.",
            "Python, Machine Learning, AI, NumPy, Pandas, " +
            "Scikit-learn, FastAPI, FAISS, XGBoost",
            "/images/internship.jpg",
            "#",
            "#"
        );
    }


    // ================================
    // LEETCODE
    // ================================

    public Project getLeetCode() {

        return new Project(
            "LeetCode Profile",
            "Actively solving Data Structures and Algorithms problems " +
            "to strengthen problem-solving, programming, and logical " +
            "thinking skills.",
            "Data Structures & Algorithms",
            "/images/leetcode.jpg",
            "https://leetcode.com/u/Mahesh_Khot/",
            "https://leetcode.com/u/Mahesh_Khot/"
        );
    }

}