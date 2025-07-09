import java.util.*;

class Neuron {
    int id;
    int energyCost;
    int priorityRank;

    Neuron(int id, int energyCost, int reward) {
        this.id = id;
        this.energyCost = energyCost;
        this.priorityRank = priorityRank;
    }

    @override
    public String toString() {
        return "Neuron[" + id + "] → Cost: " + energyCost + ", priorityRank: " + priorityRank;
    }
}

public class NeuroFuelSimulator {
    static List<Neuron> neurons = new ArrayList<>();
    static int totalEnergy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== NeuroFuel – Smart Energy Distribution ===");
        System.out.print("Enter number of neurons: ");
        int n = sc.nextInt();

        System.out.print("Enter total available energy: ");
        totalEnergy = sc.nextInt();

        System.out.println("Enter energy cost and reward for each neuron:");
        for (int i = 0; i < n; i++) {
            System.out.print("Neuron " + (i + 1) + " - Cost: ");
            int cost = sc.nextInt();
            System.out.print("Neuron " + (i + 1) + " - priorityRank: ");
            int priorityRank = sc.nextInt();
            neurons.add(new Neuron(i + 1, cost, priorityRank));
        }

        simulateEnergyDistribution();
    }

    static void simulateEnergyDistribution() {
        int n = neurons.size();
        int[][] dp = new int[n + 1][totalEnergy + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            Neuron neuron = neurons.get(i - 1);
            for (int e = 0; e <= totalEnergy; e++) {
                if (neuron.energyCost <= e) {
                    dp[i][e] = Math.max(dp[i - 1][e], neuron.priorityRank + dp[i - 1][e - neuron.energyCost]);
                } else {
                    dp[i][e] = dp[i - 1][e];
                }
            }
        }

        // Extract which neurons are activated
        int energy = totalEnergy;
        List<Neuron> activatedNeurons = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (dp[i][energy] != dp[i - 1][energy]) {
                Neuron neuron = neurons.get(i - 1);
                activatedNeurons.add(neuron);
                energy -= neuron.energyCost;
            }
        }

        // Output results
        Collections.reverse(activatedNeurons); // Maintain order
        System.out.println("\n Activated Neurons:");
        int totalCost = 0, totalpriorityRank = 0;
        for (Neuron neuron : activatedNeurons) {
            System.out.println(neuron);
            totalCost += neuron.energyCost;
            totalpriorityRank += neuron.priorityRank;
        }

        System.out.println("\n Total Energy Used: " + totalCost + " / " + totalEnergy);
        System.out.println(" Total priorityRank Collected: " + totalpriorityRank);
        System.out.println(" Remaining Energy: " + (totalEnergy - totalCost));
    }
}
