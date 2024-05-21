'use client';

import { BacktestFormData } from './backtestForm';
import BacktestForm from './backtestForm';

interface SetupSectionProps {
	submitHandler: (backtestFormData: BacktestFormData) => void;
}

const SetupSection: React.FC<SetupSectionProps> = ({ submitHandler }) => {
	return (
		<div className='flex w-full h-[calc(70vh)] border-red-200 border-2'>
			<div className='w-1/3 flex justify-center items-center p-8'>
				LeftSide
			</div>
			<div className='w-2/3 p-8'>
				<BacktestForm submitHandler={submitHandler} />
			</div>
		</div>
	);
};

export default SetupSection;
