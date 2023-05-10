package T;


import com.powernode.spring6.vo.RepaymentOrderVo;
import com.powernode.spring6.vo.RepaymentSchedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangtao
 * @date 2023/5/10
 * @apiNote
 */
public class RepaymentOrderSplit {
    public static void main(String[] args) {
        RepaymentOrderVo orderVo = new RepaymentOrderVo("Tb20230420", "NCMP001", 1, LocalDate.parse("2023-05-08"), LocalDate.parse("2023-05-08"),
                50533707, 50000000, 533107, 0, "AP202305041607050717", 50000000, 533107,
                0, 0, 0, 0, 0, "CT202305051639153992", "FS");

        RepaymentSchedule planVo1 = new RepaymentSchedule( "Tb20230420", "NCMP001", 1, LocalDate.parse("2023-05-31"), 16844369,16605739,
                 238630, 0, LocalDate.parse("2023-05-08"), "AP202305041607050717", "CT202305051639153992",3);
        RepaymentSchedule planVo2 = new RepaymentSchedule(  "Tb20230420", "NCMP001", 2, LocalDate.parse("2023-06-30"), 16844369,16660472,
                 183897, 0, LocalDate.parse("2023-05-08"), "AP202305041607050717", "CT202305051639153992",3);
        RepaymentSchedule planVo3 = new RepaymentSchedule(  "Tb20230420", "NCMP001", 3, LocalDate.parse("2023-08-05"), 16844369,16733789,
                110580, 0, LocalDate.parse("2023-05-08"), "AP202305041607050717", "CT202305051639153992",3);

        List<RepaymentOrderVo> orders = new ArrayList<>();
        orders.add(orderVo);
        List<RepaymentSchedule> plans = new ArrayList<>();
        plans.add(planVo1);
        plans.add(planVo2);
        plans.add(planVo3);

        for (RepaymentOrderVo order:orders){
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



            for(RepaymentSchedule plan:plans){
                String assetCode1 = plan.getAssetCode();
                String loanPactNo1 = plan.getLoanPactNo();
                Integer planPeriods1 = plan.getPlanPeriods();
                Integer payableMoney = plan.getPayableMoney();//应还总额
                Integer payablePrincipal = plan.getPayablePrincipal();//应还本金
                Integer payableInterest = plan.getPayableInterest();//应还利息
                Integer payablePenalty = plan.getPayablePenalty();//应还罚息
                Integer maxTerm = plan.getMaxTerm();//获取最大期数

                Integer principal_paid = 0; // 已还本金
                Integer interest_paid = 0;// 已还利息
                Integer penalty_paid = 0;// 已还罚息
                //找到对应的还款计划

/*                if (loanPactNo==loanPactNo1){
                    termNum += 1;
                }*/

                // 如果还款金额被分完了则退出循环
                if(repayPrincipal==0 && repayInterest==0)
                    break;

                if (loanPactNo1==loanPactNo1 && planPeriods1>=planPeriods){
                    RepaymentOrderVo car = new RepaymentOrderVo();
                    planPeriods=planPeriods1;
                    //还款本金 > 应还本金 则拆剩余本金
                    if (repayPrincipal>=payablePrincipal){
                        principal_paid=payablePrincipal;
                        repayPrincipal=repayPrincipal-principal_paid;

                    }else{
                        principal_paid=repayPrincipal;
                        repayPrincipal=0;
                    }

                    //还款利息 > 应还利息 则拆利息
                    if (repayInterest>=payableInterest){
                        //如果最后一期，全部放进去
                        if(maxTerm==planPeriods1){
                            interest_paid=repayInterest;
                            repayInterest=0;
                        }else {
                            interest_paid=payableInterest;
                            repayInterest=repayInterest-interest_paid;
                        }
                    }else{
                        interest_paid=repayInterest;
                        repayInterest=0;
                    }

                    //还款罚息 > 应还罚息 则拆罚息
                    if (repayPenalty>=payablePenalty){
                        //如果最后一期，全部放进去
                        if(maxTerm==planPeriods1){
                            penalty_paid=repayPenalty;
                            repayPenalty=0;
                        }else {
                            penalty_paid = payablePenalty;
                            repayPenalty = repayPenalty - penalty_paid;
                        }
                    }else{
                        penalty_paid=repayPenalty;
                        repayPenalty=0;
                    }

                    //System.out.println(planPeriods + ", " +principal_paid + ", " +interest_paid + ", " +penalty_paid);
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
