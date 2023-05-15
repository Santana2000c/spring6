package T;


import com.powernode.spring6.vo.RepaymentOrderVo;
import com.powernode.spring6.vo.RepaymentSchedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangguangtao
 * @date 2023/5/10
 * @apiNote
 */
public class RepaymentOrderSplit {
    public static void main(String[] args) {

        RepaymentOrderVo orderVo1 = new RepaymentOrderVo("Tb20230420","HHQQ001",1,LocalDate.parse("2023-05-11"),LocalDate.parse("2023-05-11"),16970,16585,385,0,"AP202305041607050717",16585,385,0,0,0,0,0,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo2 = new RepaymentOrderVo("Tb20230420","HHQQ001",2,LocalDate.parse("2023-05-12"),LocalDate.parse("2023-05-11"),9800,9341,459,0,"AP202305041607050717",9341,459,0,0,0,0,0,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo3 = new RepaymentOrderVo("Tb20230420","HHQQ001",2,LocalDate.parse("2023-05-13"),LocalDate.parse("2023-05-11"),7170,7170,0,0,"AP202305041607050717",7170,0,0,0,0,0,0,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo4 = new RepaymentOrderVo("Tb20230420","HHQQ001",2,LocalDate.parse("2023-05-14"),LocalDate.parse("2023-05-11"),10000,9341,459,0,"AP202305041607050717",0,0,0,9341,459,0,20,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo5 = new RepaymentOrderVo("Tb20230420","HHQQ001",2,LocalDate.parse("2023-05-15"),LocalDate.parse("2023-05-11"),7170,7170,0,0,"AP202305041607050717",0,0,0,7170,0,0,14,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo6 = new RepaymentOrderVo("Tb20230420","HHQQ001",3,LocalDate.parse("2023-05-16"),LocalDate.parse("2023-05-11"),9700,9320,380,0,"AP202305041607050717",9320,380,0,0,0,0,0,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo7 = new RepaymentOrderVo("Tb20230420","HHQQ001",3,LocalDate.parse("2023-05-17"),LocalDate.parse("2023-05-11"),24281,23954,286,41,"AP202305041607050717",23954,286,41,0,0,0,0,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo8 = new RepaymentOrderVo("Tb20230420","HHQQ001",3,LocalDate.parse("2023-05-18"),LocalDate.parse("2023-05-11"),10000,9320,380,0,"AP202305041607050717",0,0,0,9320,380,0,20,"CT202305051639153992","NF");
        RepaymentOrderVo orderVo9 = new RepaymentOrderVo("Tb20230420","HHQQ001",3,LocalDate.parse("2023-05-19"),LocalDate.parse("2023-05-11"),24681,23954,286,41,"AP202305041607050717",0,0,0,23954,286,41,49,"CT202305051639153992","NF");

        RepaymentSchedule planVo1 = new RepaymentSchedule("Tb20230420","HHQQ001",1,LocalDate.parse("2023-06-01"),16970,16585,385,0,LocalDate.parse("2023-05-11"),"AP202305041607050717","CT202305051639153992",6);
        RepaymentSchedule planVo2 = new RepaymentSchedule("Tb20230420","HHQQ001",2,LocalDate.parse("2023-07-01"),16970,16511,459,0,LocalDate.parse("2023-05-11"),"AP202305041607050717","CT202305051639153992",6);
        RepaymentSchedule planVo3 = new RepaymentSchedule("Tb20230420","HHQQ001",3,LocalDate.parse("2023-08-01"),16970,16590,380,0,LocalDate.parse("2023-05-11"),"AP202305041607050717","CT202305051639153992",6);
        RepaymentSchedule planVo4 = new RepaymentSchedule("Tb20230420","HHQQ001",4,LocalDate.parse("2023-09-01"),16970,16684,286,0,LocalDate.parse("2023-05-11"),"AP202305041607050717","CT202305051639153992",6);
        RepaymentSchedule planVo5 = new RepaymentSchedule("Tb20230420","HHQQ001",5,LocalDate.parse("2023-10-01"),16970,16785,185,0,LocalDate.parse("2023-05-11"),"AP202305041607050717","CT202305051639153992",6);
        RepaymentSchedule planVo6 = new RepaymentSchedule("Tb20230420","HHQQ001",6,LocalDate.parse("2023-11-11"),16970,16845,125,0,LocalDate.parse("2023-05-11"),"AP202305041607050717","CT202305051639153992",6);

        List<RepaymentOrderVo> orders = new ArrayList<>();
        orders.add(orderVo1);
        orders.add(orderVo2);
        orders.add(orderVo3);
        orders.add(orderVo4);
        orders.add(orderVo5);
        orders.add(orderVo6);
        orders.add(orderVo7);
        orders.add(orderVo8);
        orders.add(orderVo9);

        List<RepaymentSchedule> plans = new ArrayList<>();
        plans.add(planVo1);
        plans.add(planVo2);
        plans.add(planVo3);
        plans.add(planVo4);
        plans.add(planVo5);
        plans.add(planVo6);


        insertRepaymentOrder(orders, plans);


    }

    private static void insertRepaymentOrder(List<RepaymentOrderVo> orders, List<RepaymentSchedule> plans) {
        Map<String,List<Integer>> new_repay_record_dict = new HashMap<>();
        for (RepaymentOrderVo order: orders){
            String trustCode = order.getTrustCode();
            String loanPactNo = order.getLoanPactNo();
            Integer planPeriods = order.getPlanPeriods();
            LocalDate execDate = order.getExecDate();
            LocalDate realRepayDate = order.getRealRepayDate();
            Integer repayPrincipal = order.getRepayPrincipal();
            Integer repayInterest = order.getRepayInterest();
            Integer repayPenalty = order.getRepayPenalty();
            String assetCode = order.getAssetCode();
            Integer trustRepayPrincipal = order.getTrustRepayPrincipal();
            Integer trustRepayInterest = order.getTrustRepayInterest();
            Integer trustRepayPenalty = order.getTrustRepayPenalty();
            Integer assetRepayPrincipal = order.getAssetRepayPrincipal();
            Integer assetRepayInterest = order.getAssetRepayInterest();
            Integer assetRepayPenalty = order.getAssetRepayPenalty();
            String transferCode = order.getTransferCode();
            Integer repayFee = order.getRepayFee();
            String repayType = order.getRepayType();



            for(RepaymentSchedule plan: plans){
                String loanPactNo1 = plan.getLoanPactNo();
                Integer planPeriods1 = plan.getPlanPeriods();
                Integer payablePrincipal = plan.getPayablePrincipal();//应还本金
                Integer payableInterest = plan.getPayableInterest();//应还利息
                Integer payablePenalty = plan.getPayablePenalty();//应还罚息
                Integer maxTerm = plan.getMaxTerm();//获取最大期数

                Integer principal_paid = 0; // 已还本金
                Integer interest_paid = 0;// 已还利息
                Integer penalty_paid = 0;// 已还罚息

                //获取剩余金额
                if(new_repay_record_dict.get(loanPactNo1 + "_" + planPeriods1) != null ) {
                    payablePrincipal = new_repay_record_dict.get(loanPactNo1 + "_" + planPeriods1).get(0);
                    payableInterest = new_repay_record_dict.get(loanPactNo1 + "_" + planPeriods1).get(1);
                }

                // 如果还款金额被分完了则退出循环
                if(repayPrincipal==0 && repayInterest==0 && repayPenalty==0)
                    break;

                if (loanPactNo1==loanPactNo1 && planPeriods1>=planPeriods){
                    RepaymentOrderVo car = new RepaymentOrderVo();
                    planPeriods=planPeriods1;
                    //还款本金 > 应还本金 则拆剩余本金
                    if (repayPrincipal>=payablePrincipal){
                        if(maxTerm==planPeriods1){
                            principal_paid=repayPrincipal;
                            repayPrincipal=0;
                        }else{
                            principal_paid=payablePrincipal;
                            repayPrincipal=repayPrincipal-principal_paid;
                            payablePrincipal=0; //剩余应还为0
                        }
                    }else{
                        principal_paid=repayPrincipal;
                        repayPrincipal=0; //剩余拆分为0
                        payablePrincipal=payablePrincipal-principal_paid;
                    }

                    //还款利息 > 应还利息 则拆利息
                    if (repayInterest>=payableInterest){
                        //如果最后一期，全部放进去
                        //Todo
                        if(maxTerm==planPeriods1){
                            interest_paid=repayInterest;
                            repayInterest=0;
                            payableInterest=0;
                        }else {
                            interest_paid=payableInterest;
                            repayInterest=repayInterest-interest_paid;
                            payableInterest=0;
                        }
                    }else{
                        interest_paid=repayInterest;
                        repayInterest=0;
                        payableInterest=payableInterest-interest_paid;
                    }

                    //罚息，只写一次，记在对应的期上或者最后一期
                    if (repayPenalty>0 && (planPeriods==planPeriods1 || planPeriods1==maxTerm)){
                        penalty_paid=repayPenalty;
                        repayPenalty=0;
                    }

                    if (principal_paid>0 || interest_paid>0 || penalty_paid >0){
                        //保存数据
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(payablePrincipal );
                        list.add(payableInterest);
                        new_repay_record_dict.put(loanPactNo1+'_'+planPeriods1,list);

                        car.setAssetCode(assetCode);
                        car.setLoanPactNo(loanPactNo);
                        car.setPlanPeriods(planPeriods);
                        car.setExecDate(execDate);
                        car.setRealRepayDate(realRepayDate);
                        car.setRepayMoney(principal_paid+interest_paid+penalty_paid);
                        car.setRepayPrincipal(principal_paid);
                        car.setRepayInterest(interest_paid);
                        car.setRepayPenalty(penalty_paid);
                        car.setRepayFee(repayFee);
                        car.setRepayType(repayType);
                        car.setTrustCode(trustCode);
                        car.setTrustRepayPrincipal(trustRepayPrincipal);
                        car.setTrustRepayInterest(trustRepayInterest);
                        car.setTrustRepayPenalty(trustRepayPenalty);
                        car.setAssetRepayPrincipal(assetRepayPrincipal);
                        car.setAssetRepayInterest(assetRepayInterest);
                        car.setAssetRepayPenalty(assetRepayPenalty);
                        car.setTransferCode(transferCode);

                        System.out.println(car);

                    }


                }

            }

        }
    }
}
