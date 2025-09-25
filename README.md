Network Sniffer Tool (Java)

Overview

The Network Sniffer Tool is a Java-based application for real-time network packet capture and analysis. 
It monitors network traffic across TCP, UDP, ICMP, and HTTP protocols, providing detailed insights into packet flow, traffic patterns, and potential security threats. 
This project is ideal for network administrators, cybersecurity enthusiasts, and SOC analysts.

Features

Real-time Packet Capture: Captures live network packets using Java networking APIs.

Protocol Analysis: Supports TCP, UDP, ICMP, and HTTP protocols with accurate parsing and identification.

Traffic Metrics & Anomaly Detection: Calculates packet size distribution, top talkers, and detects unusual traffic patterns.

Interactive Monitoring Interface: Displays captured traffic and protocol summaries via a console or GUI.

Security Monitoring: Highlights suspicious activity to support proactive threat detection.

How It Works

Captures network packets using Java networking libraries (java.net or jpcap).

Parses packet headers and payloads to extract protocol-specific data.

Computes metrics like packet size distribution, top talkers, and unusual activity detection.

Flags suspicious traffic for review.

Provides monitoring interface for real-time traffic visualization and analysis.

