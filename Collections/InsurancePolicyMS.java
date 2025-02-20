package AssignmentCollectionFramework;

import java.util.*;

class insurancePolicy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public insurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof insurancePolicy)) return false;
        insurancePolicy other = (insurancePolicy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

class insurancePolicyManager {
    private Set<insurancePolicy> policyHashSet = new HashSet<>();
    private Set<insurancePolicy> policyLinkedHashSet = new LinkedHashSet<>();
    private Set<insurancePolicy> policyTreeSet = new TreeSet<>(Comparator.comparing(policy -> policy.expiryDate));

    public void addPolicy(insurancePolicy policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }

    public Set<insurancePolicy> getAllUniquePolicies() {
        return new HashSet<>(policyHashSet);
    }

    public List<insurancePolicy> getPoliciesExpiringSoon() {
        List<insurancePolicy> soonToExpire = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date next30Days = cal.getTime();

        for (insurancePolicy policy : policyTreeSet) {
            if (policy.expiryDate.after(today) && policy.expiryDate.before(next30Days)) {
                soonToExpire.add(policy);
            }
        }
        return soonToExpire;
    }

    public List<insurancePolicy> getPoliciesByCoverageType(String coverageType) {
        List<insurancePolicy> result = new ArrayList<>();
        for (insurancePolicy policy : policyLinkedHashSet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    public Set<insurancePolicy> getDuplicatePolicies() {
        Set<insurancePolicy> duplicates = new HashSet<>();
        Set<insurancePolicy> seen = new HashSet<>();
        for (insurancePolicy policy : policyHashSet) {
            if (!seen.add(policy)) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public void performanceComparison(int numberOfPolicies) {
        long startTime, endTime;

        // HashSet Performance
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfPolicies; i++) {
            addPolicy(new insurancePolicy("P" + i, "Policyholder" + i, new Date(System.currentTimeMillis() + (i * 86400000)), "Health", 100 + i));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet Add Time: " + (endTime - startTime) + " ns");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfPolicies; i++) {
            addPolicy(new insurancePolicy("P" + i, "Policyholder" + i, new Date(System.currentTimeMillis() + (i * 86400000)), "Auto", 200 + i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) + " ns");

        // TreeSet Performance
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfPolicies; i++) {
            addPolicy(new insurancePolicy("P" + i, "Policyholder" + i, new Date(System.currentTimeMillis() + (i * 86400000)), "Home", 300 + i));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (endTime - startTime) + " ns");
    }
}

public class InsurancePolicyMS {
    public static void main(String[] args) {
        insurancePolicyManager policyManager = new insurancePolicyManager();

        policyManager.addPolicy(new insurancePolicy("P001", "ASHII", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "Health", 150.0));
        policyManager.addPolicy(new insurancePolicy("P002", "BABITA", new GregorianCalendar(2025, Calendar.MARCH, 20).getTime(), "Auto", 250.0));
        policyManager.addPolicy(new insurancePolicy("P003", "CHINKI", new GregorianCalendar(2025, Calendar.APRIL, 10).getTime(), "Home", 350.0));
        policyManager.addPolicy(new insurancePolicy("P001", "AKASH", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "Health", 150.0));

        System.out.println("All unique policies: " + policyManager.getAllUniquePolicies());
        System.out.println("Policies expiring soon: " + policyManager.getPoliciesExpiringSoon());
        System.out.println("Health policies: " + policyManager.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate policies: " + policyManager.getDuplicatePolicies());

        policyManager.performanceComparison(1000);
    }
}

