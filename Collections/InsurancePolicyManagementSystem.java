//package AssignmentCollectionFramework;
//
//import java.util.*;
//
//class InsurancePolicy {
//    String policyNumber;
//    String policyholderName;
//    Date expiryDate;
//
//    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate) {
//        this.policyNumber = policyNumber;
//        this.policyholderName = policyholderName;
//        this.expiryDate = expiryDate;
//    }
//}
//
//class InsurancePolicyManager {
//    private Map<String, insurancePolicy> policiesMap = new LinkedHashMap<>();
//    private TreeMap<Date, List<insurancePolicy>> policiesByExpiryDate = new TreeMap<>();
//
//    public void addPolicy(insurancePolicy policy) {
//        policiesMap.put(policy.policyNumber, policy);
//        policiesByExpiryDate.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
//    }
//
//    public insurancePolicy getPolicy(String policyNumber) {
//        return policiesMap.get(policyNumber);
//    }
//
//    public List<insurancePolicy> listPoliciesExpiringSoon() {
//        List<insurancePolicy> soonToExpire = new ArrayList<>();
//        Date today = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_YEAR, 30);
//        Date next30Days = cal.getTime();
//
//        for (Map.Entry<Date, List<insurancePolicy>> entry : policiesByExpiryDate.subMap(today, next30Days).entrySet()) {
//            soonToExpire.addAll(entry.getValue());
//        }
//        return soonToExpire;
//    }
//
//    public List<insurancePolicy> listPoliciesByPolicyholder(String policyholderName) {
//        List<insurancePolicy> result = new ArrayList<>();
//        for (insurancePolicy policy : policiesMap.values()) {
//            if (policy.policyholderName.equals(policyholderName)) {
//                result.add(policy);
//            }
//        }
//        return result;
//    }
//
//    public void removeExpiredPolicies() {
//        Date today = new Date();
//        policiesMap.values().removeIf(policy -> policy.expiryDate.before(today));
//        policiesByExpiryDate.entrySet().removeIf(entry -> entry.getKey().before(today));
//    }
//}
//
//class VotingSystem {
//    private Map<String, Integer> votesMap = new HashMap<>();
//    private LinkedHashMap<String, Integer> orderedVotes = new LinkedHashMap<>();
//
//    public void castVote(String candidate) {
//        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
//        orderedVotes.put(candidate, votesMap.get(candidate));
//    }
//
//    public Map<String, Integer> getResultsSortedByVotes() {
//        TreeMap<Integer, List<String>> sortedResults = new TreeMap<>(Collections.reverseOrder());
//        for (Map.Entry<String, Integer> entry : votesMap.entrySet()) {
//            sortedResults.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
//        }
//        return flattenResults(sortedResults);
//    }
//
//    private Map<String, Integer> flattenResults(TreeMap<Integer, List<String>> sortedResults) {
//        Map<String, Integer> result = new LinkedHashMap<>();
//        for (Map.Entry<Integer, List<String>> entry : sortedResults.entrySet()) {
//            for (String candidate : entry.getValue()) {
//                result.put(candidate, entry.getKey());
//            }
//        }
//        return result;
//    }
//}
//
//class ShoppingCart {
//    private Map<String, Double> productPrices = new HashMap<>();
//    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
//
//    public void addProduct(String productName, double price) {
//        productPrices.put(productName, price);
//    }
//
//    public void addItemToCart(String productName, int quantity) {
//        cartItems.put(productName, cartItems.getOrDefault(productName, 0) + quantity);
//    }
//
//    public TreeMap<Double, List<String>> getItemsSortedByPrice() {
//        TreeMap<Double, List<String>> sortedItems = new TreeMap<>();
//        for (String product : cartItems.keySet()) {
//            double price = productPrices.get(product);
//            sortedItems.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
//        }
//        return sortedItems;
//    }
//}
//
//class CustomerAccount {
//    String accountNumber;
//    double balance;
//
//    public CustomerAccount(String accountNumber, double balance) {
//        this.accountNumber = accountNumber;
//        this.balance = balance;
//    }
//}
//
//class BankingSystem {
//    private Map<String, CustomerAccount> accountsMap = new HashMap<>();
//    private TreeMap<Double, List<CustomerAccount>> accountsByBalance = new TreeMap<>();
//    private Queue<String> withdrawalQueue = new PriorityQueue<>();
//
//    public void addAccount(CustomerAccount account) {
//        accountsMap.put(account.accountNumber, account);
//        accountsByBalance.computeIfAbsent(account.balance, k -> new ArrayList<>()).add(account);
//    }
//
//    public void requestWithdrawal(String accountNumber) {
//        withdrawalQueue.add(accountNumber);
//    }
//
//    public void processWithdrawals() {
//        while (!withdrawalQueue.isEmpty()) {
//            String accountNumber = withdrawalQueue.poll();
//            CustomerAccount account = accountsMap.get(accountNumber);
//            if (account != null && account.balance > 0) {
//                // Implement withdrawal logic
//            }
//        }
//    }
//
//    public Map<String, CustomerAccount> getAccountsSortedByBalance() {
//        Map<String, CustomerAccount> sortedAccounts = new LinkedHashMap<>();
//        for (Map.Entry<Double, List<CustomerAccount>> entry : accountsByBalance.descendingMap().entrySet()) {
//            for (CustomerAccount account : entry.getValue()) {
//                sortedAccounts.put(account.accountNumber, account);
//            }
//        }
//        return sortedAccounts;
//    }
//}
//
//public class InsurancePolicyManagementSystem {
//    public static void main(String[] args) {
//        insurancePolicyManager policyManager = new insurancePolicyManager();
//        policyManager.addPolicy(new insurancePolicy("HSJHDJ1", "KIRTI", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime()));
//        policyManager.addPolicy(new insurancePolicy("PKKKIIU2", "PRATIKSHA", new GregorianCalendar(2025, Calendar.MARCH, 20).getTime()));
//
//        System.out.println("Policies expiring soon: " + policyManager.listPoliciesExpiringSoon());
//        policyManager.removeExpiredPolicies();
//
//        VotingSystem votingSystem = new VotingSystem();
//        votingSystem.castVote("Candidate A");
//        votingSystem.castVote("Candidate B");
//        votingSystem.castVote("Candidate A");
//
//        System.out.println("Voting results: " + votingSystem.getResultsSortedByVotes());
//
//        ShoppingCart cart = new ShoppingCart();
//        cart.addProduct("Laptop", 1200.00);
//        cart.addProduct("Smartphone", 800.00);
//        cart.addItemToCart("Laptop", 1);
//        cart.addItemToCart("Smartphone", 2);
//
//        System.out.println("Items sorted by price: " + cart.getItemsSortedByPrice());
//
//        BankingSystem bankingSystem = new BankingSystem();
//        bankingSystem.addAccount(new CustomerAccount("A123", 1000.00));
//        bankingSystem.addAccount(new CustomerAccount("B456", 1500.00));
//
//        bankingSystem.requestWithdrawal("A123");
//        bankingSystem.processWithdrawals();
//
//        System.out.println("Accounts sorted by balance: " + bankingSystem.getAccountsSortedByBalance());
//    }
//}
