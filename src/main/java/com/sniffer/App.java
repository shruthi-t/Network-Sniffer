package com.sniffer;

import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            // Get all available network interfaces
            List<PcapNetworkInterface> devices = Pcaps.findAllDevs();
            if (devices == null || devices.isEmpty()) {
                System.out.println("No network interfaces found.");
                return;
            }

            // Print all available interfaces
            System.out.println("Available Network Interfaces:");
            for (int i = 0; i < devices.size(); i++) {
                System.out.println(i + ": " + devices.get(i).getName() + " - " + devices.get(i).getDescription());
            }

            // Let user select an interface
            System.out.print("Enter the interface number to listen on: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.close();

            if (choice < 0 || choice >= devices.size()) {
                System.out.println("Invalid choice.");
                return;
            }

            PcapNetworkInterface device = devices.get(choice);
            System.out.println("Listening on: " + device.getName());

            // Open the network interface for packet capture
            int snapLen = 65536;
            PcapHandle handle = device.openLive(snapLen, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, 50);

            // Define a packet listener
            PacketListener listener = packet -> {
                System.out.println("Packet captured: " + packet);
                System.out.println("Packet Length: " + packet.length());
            };

            // Capture packets indefinitely
            handle.loop(-1, listener);

            // Close the handle when done
            handle.close();

        } catch (PcapNativeException | NotOpenException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
